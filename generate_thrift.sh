#!/bin/bash
#   Copyright (C) 2013-2014 Computer Sciences Corporation
#
#   Licensed under the Apache License, Version 2.0 (the "License");
#   you may not use this file except in compliance with the License.
#   You may obtain a copy of the License at
#
#       http://www.apache.org/licenses/LICENSE-2.0
#
#   Unless required by applicable law or agreed to in writing, software
#   distributed under the License is distributed on an "AS IS" BASIS,
#   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
#   See the License for the specific language governing permissions and
#   limitations under the License.


# echo commands before executing them

THRIFT_BINARY=${1:-thrift}

# TODO (soup): Add a way to include dependencies

function echo_and_execute_command()
{
    local cmd=$1
    echo ${cmd}
    ${cmd}
}



BUILD_DIR=`mktemp -d thrift_generatorXXX`
THRIFT_ARGS="-I ../ezbake-base-thrift/src/main/thrift -o ${BUILD_DIR}"
echo "GENERATING THRIFT FILES"

for f in src/main/thrift/*.thrift; do
    echo_and_execute_command "${THRIFT_BINARY} ${THRIFT_ARGS} --gen java:hashcode $f"
    if [ $? -ne 0 ]; then
        echo  -ne "\n\nError:An error occurred when running thrift commands.\n" >&2
        exit
    fi

    echo_and_execute_command "${THRIFT_BINARY} ${THRIFT_ARGS} --gen cpp:cob_style $f"
    if [ $? -ne 0 ]; then
        echo  -ne "\n\nError:An error occurred when running thrift commands.\n" >&2
        exit
    fi

    echo_and_execute_command "${THRIFT_BINARY} ${THRIFT_ARGS} --gen py:new_style $f"
    if [ $? -ne 0 ]; then
        echo  -ne "\n\nError:An error occurred when running thrift commands.\n" >&2
        exit
    fi

    echo_and_execute_command "${THRIFT_BINARY} ${THRIFT_ARGS} --gen js:node $f"
    if [ $? -ne 0 ]; then
        echo  -ne "\n\nError:An error occurred when running thrift commands.\n" >&2
        exit
    fi
done

#copy generated java files
for f in `find ./${BUILD_DIR}/gen-java -name "*.java"`
do
    file_name=`basename $f`
    tmp_var=`echo $f | cut -d "/" -f4-`
    dir_name=`dirname $tmp_var` 
    dest="src/main/java/${dir_name}"
    if [ ! -d $dest ]; then
        echo "Creating $dest"
        echo_and_execute_command "mkdir -p ${dest}"
    fi
    echo_and_execute_command "cp -fv $f ${dest}"
done

#copy generated cpp files
for f in `find ./${BUILD_DIR}/gen-cpp -name "*.cpp"`
do
    if test "${f#*skeleton}" != "$f"; then
        #do not include generated thrift .skeleton. files
        continue
    fi
    echo_and_execute_command "cp -fv $f src/main/cpp"
done
for f in `find ./${BUILD_DIR}/gen-cpp -name "*.h"`
do
    echo_and_execute_command "cp -fv $f src/main/cpp/include"
done

#copy generated python files
echo_and_execute_command "rm -rf src/main/python/*"
echo_and_execute_command "cp -rfv ${BUILD_DIR}/gen-py/* src/main/python/."

#copy generated python files
echo_and_execute_command "rm -rf src/main/node/*"
echo_and_execute_command "cp -rfv ${BUILD_DIR}/gen-nodejs/* src/main/node/."

echo "Removing Build Directory"
echo_and_execute_command "rm -rf ${BUILD_DIR}"
