/*   Copyright (C) 2013-2014 Computer Sciences Corporation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License. */

namespace java ezbake.services.provenance.thrift
include "ezbakeBaseTypes.thrift"
include "ezbakeBaseService.thrift"

const string SERVICE_NAME = "EzProvenanceService"

struct InheritanceInfo {
    /* Specifies the URI from which this data was derived */
    1: required string parentUri

    /* If the parent’s age-off information should be inherited
       this should be true. Note that if the optional
       ageOffRelevantDateTime parameter below is not set, then
       not only are the parent’s age-off groups inherited but the
       ageOffRelevantDate time for each of those groups is inherited
       as well.*/
    2: required bool inheritParentAgeOff

    /* If inheritParentAgeOff was true, then if trackParentAgeOff is true,
       edits to the parent document’s age off rules will be reflected in the
       the rules of this child at the time the edit is made. If
       ageOffRelevantDateTime (below) is not set, parent values will be used
       when new parent rules are added */
    3: required bool trackParentAgeOff

    /* If set, this is the ageOffRelevantDateTime used on all age-off
       groups inherited from the parent */
    4: optional ezbakeBaseTypes.DateTime ageOffRelevantDateTime

}

struct AccumuloContinuationPoint{
    /* if true, start at the beginning of the query with no continuation
    *  point. If false use the rowId, colFam, colQual in this structure,
    *  ignoring whatever else is in the query*/
    1: required bool startAtBeginning;

    2: optional string rowId;
    3: optional string colFam;
    4: optional string colQual;

}

struct ResultsAndContinuation {
    1: required list<string> results,

    /* continuation point should be set to an empty string if it is
       known that there are no further results to retrieve*/
    2: required AccumuloContinuationPoint continuationPoint,
}

struct AgeOffMapping {
    /* The ID of the Age-Off rule that applies */
    1: required i64 ruleId

    /* The time that should be used when comparing this data against the rule */
    2: required ezbakeBaseTypes.DateTime ageOffRelevantDateTime
}

/* The structure output from the getDocumentAncestors() and getDocumentDescendants() method */
struct DerivedResult {
    /* The ids corresponding to a requested list of uris and all documents/uris derived from that list */
    1: required set<i64> derivedDocs,

    /* The list of uris in the request that were not found in the provenance service */
    2: required list<string> urisNotFound,

    /* Included if only a single uri is in the request.
       This is the ids corresponding to the immediate children of the requested uri */
    3: optional list<i64> immediateChildren,
}

struct DocumentAgeOffInfo {
    1: required i64 ruleId,
    2: required ezbakeBaseTypes.DateTime ageOffRelevantDateTime,

    /* The maximum allowable period (in days) between automatic execution of an age off for this rule.
       Allowed values are 1-90 */
    3: required i32 maximumExecutionPeriod
    4: required ezbakeBaseTypes.DateTime timeStamp,
    5: required string application,
    6: required string user,
    7: required bool inherited,
    8: optional i64 inheritedFromId,
    9: optional string inheritedFromUri
}

struct DocumentInfo {
    1: required string uri,
    2: required i64 documentId,
    3: required string application
    4: required ezbakeBaseTypes.DateTime timeStamp,
    5: required string user,
    /* the map i64:string is id:uri */
    6: required list<map<i64,string>> parents,
    /* the map i64:string is id:uri */
    7: required list<map<i64,string>> children,
    8: required list<DocumentAgeOffInfo> ageOffInfo,
    9: required bool aged,
}

/* The structure output from getDocumentConvertedUrisFromIds() and getDocumentConvertedUrisFromUris()*/
struct ConversionResult {
    /* The list of ids in the request uris/ids that were found */
    1: required list<i64> convertedUris,

    /* The list of uris in the request that were not found in the
       provenance service when getDocumentConvertedUrisFromUris() is called*/
    2: optional list<string> urisNotFound,

    /* The list of uris in the request that were not found in the
       provenance service when getDocumentConvertedUrisFromIds() is called*/
    3: optional list<i64> idsNotFound
}

/* The structure output from the startAgeOffEvent() method */
struct AgeOffInitiationResult {
    /* This ID should come from the same ID generator as age off
       events. The provenance service never uses the ageOffId
       once generated. It simply must never conflict with a
       purge event ID.*/
    1: required i64 ageOffId,

    /* The set of document IDs for which the age off applies */
    2: required set<i64> ageOffDocumentIds
 }


/* The structure output from the markDocumentForPurge() method */
struct PurgeInitiationResult {
    /* The document Ids correspond to document URIs to be purged from the system. */
    1: required set<i64> toBePurged,

    /* The list of uris in the request that were not found in the provenance service */
    2: required list<string> urisNotFound,

    /* The unique identifier for this purge */
    3: required i64 purgeId
}

/* The structure output from the getPurgeInfo() method, it basically
   just represents the PurgeEvent vertex */
struct PurgeInfo {
    /* A unique ID generated to represent this purge event */
    1: required i64 id,

    /* The time at which this purge event was created */
    2: required ezbakeBaseTypes.DateTime timeStamp,

    /* The list of document IDs that should serve as the starting point for the purge */
    3: required list<string> documentUris,

    /* Members of DocumentUris that could not be found in the system at
       the time of purge */
    4: required list<string> documentUrisNotFound,

    /* The document IDs corresponding to the found URIs within DocumentUris at time of purge initiation */
    5: required set<i64> purgeDocumentIds,

    /* The document IDs corresponding to the URIs that the purge service acknowledges have been completely purged from the system.
       This set is empty when markDocumentForPurge() creates this vertex and is populated by subsequent calls from the purge service. */
    6: required set<i64> completelyPurgedDocumentIds,

    /* Put the UserInfo.principal value in this field from the EzSecurityToken
       into this property  to indicate who initiated the purge */
    7: required string user

    /* The text name for the purge */
    8: optional string name,

    /* A longer text description of the purge.  */
    9: optional string description

    /* A flag indicating that when true means this purge is no longer being processed */
    10: required bool resolved
}

/* the structure returned from getUrsFromBitPositions */
struct PositionsToUris {
    /* A mapping of bit positions for which URIs were requested to the URIs*/
    1: required map<i64, string> mapping,

    /* A list of any positions that were requested but for which no URIs were found */
    2: required list<i64> unfoundPositionList,
}

struct AgeOffRule {
    1: required string name
    2: required i64 id
    3: required i64 retentionDurationSeconds
    4: required i32 maximumExecutionPeriod
    5: required string application
    6: required string user
    7: required ezbakeBaseTypes.DateTime timeStamp
}

struct AddDocumentEntry {
    1: required string uri
    2: optional set<InheritanceInfo> parents
}

enum AddDocumentStatus {
    SUCCESS,
    ALREADY_EXISTS,
    PARENT_NOT_FOUND,
    CIRCULAR_INHERITANCE_NOT_ALLOWED,
    UNKNOWN_ERROR
}

struct AddDocumentResult {
    1: required AddDocumentStatus status
    2: optional i64 documentId    /* the generated documentId when status is SUCCESS */
    3: optional list<string> parentsNotFound   /* when status is PARENT_NOT_FOUND */
}

enum ObjectAccessType{
    CREATE,
    READ,
    WRITE,
    MANAGE,
    DELETE
}

exception ProvenanceDocumentNotFoundException {
    1: string message
}

exception ProvenanceParentDocumentNotFoundException {
    1: string message
    2: list<string> parentUris
}

exception ProvenanceAgeOffRuleNameExistsException {
    1: string message
}

exception ProvenanceIllegalAgeOffDurationSecondsException {
    1: string message
}

exception ProvenanceIllegalAgeOffRuleNameException {
    1: string message
}

exception ProvenanceIllegalMaximumExecutionPeriodException {
    1: string message
}

exception ProvenanceAgeOffRuleNotFoundException {
    1: string message
}

exception ProvenanceDocumentExistsException {
    1: string message
}

exception ProvenanceCircularInheritanceNotAllowedException {
    1: string message
}

exception ProvenancePurgeIdNotFoundException {
    1: string message
}

exception ProvenanceAgeOffExistsException {
    1: string message
}

exception ProvenanceAgeOffInheritanceExistsException {
    1: string message
}

exception ProvenanceDocumentNotInPurgeException {
     1: string message
}

exception ProvenanceAlreadyAgedException {
    1: string message
}

exception ProvenanceExceedsMaxBatchSizeException {
    1: string message
}

service ProvenanceService extends ezbakeBaseService.EzBakeBaseService
{
    /*
    Allows apps / users to add new age off rules to the system. The name must be unique.
    Throws EzSecurityTokenException exception if the securityToken is not valid.
    Throws ProvenanceAgeOffRuleNameExistsException exception if a call to this method tries to use an existing name.
    Throws ProvenanceIllegalAgeOffDurationSecondsException exception if the retentionDurationSeconds is set to 0.
    Throws ProvenanceIllegalAgeOffRuleNameException exception if the name is an empty string.
    Throws ProvenanceIllegalMaximumExecutionPeriodException exception if the maximumExecutionPeriod is not between 1 and 90 days.
    Returns the i64 id of the new AgeOffRule vertex.
    */
    i64 addAgeOffRule(1: required ezbakeBaseTypes.EzSecurityToken securityToken
                      2: required string name
                      3: required i64 retentionDurationSeconds
                      4: required i32 maximumExecutionPeriod)
                    throws
                     (1: ezbakeBaseTypes.EzSecurityTokenException security
                      2: ProvenanceAgeOffRuleNameExistsException nameExists
                      3: ProvenanceIllegalAgeOffDurationSecondsException illegalAgeOffDurationSeconds
                      4: ProvenanceIllegalAgeOffRuleNameException illegalAgeOffName
                      5: ProvenanceIllegalMaximumExecutionPeriodException illegalMaxPeriod)


    /*
    Allows for the querying of existing AgeOff rules by the Id of the AgeOffRule.
    Throws EzSecurityTokenException exception if the securityToken is not valid.
    Throws ProvenanceAgeOffRuleNotFoundException exception if the ruleId does not correspond to an AgeOffRule vertex.
    Returns AgeOffRule structure populated from the corresponding properties in the queried vertex.
    */
    AgeOffRule getAgeOffRuleById(1: required ezbakeBaseTypes.EzSecurityToken securityToken
                             2: required i64 ruleId)
                           throws
                            (1: ezbakeBaseTypes.EzSecurityTokenException security
                             2: ProvenanceAgeOffRuleNotFoundException ruleNotFound)

    /*
    Allows for the querying of existing AgeOff rules by the name of the AgeOffRule.
    Throws EzSecurityTokenException if the securityToken is not valid.
    Throws ProvenanceAgeOffRuleNotFoundException if the name does not correspond to an AgeOffRule vertex.
    Returns AgeOffRule structure populated from the corresponding properties in the queried vertex.
    */
    AgeOffRule getAgeOffRule(1: required ezbakeBaseTypes.EzSecurityToken securityToken
                                 2: required string name)
                               throws
                                (1: ezbakeBaseTypes.EzSecurityTokenException security
                                 3: ProvenanceAgeOffRuleNotFoundException ruleNotFound)

    /*
    Updates the AgeOffRule vertex’s Duration with the retentionDurationSeconds parameter.
    Application, TimeStamp, and User will also be updated as if this were an addAgeOffRule() call.
    Throws EzSecurityToken exception if the securityToken is invalid.
    Throws ProvenanceAgeOffRuleNotFound exception if there is no rule matching the name.
    Throws ProvenanceIllegalAgeOffDurationSecondsException if the retentionDurationSeconds is set to 0.
    Throws ProvenanceIllegalAgeOffRuleNameException if the name is an empty string.
    */
    void updateAgeOffRule(1: required ezbakeBaseTypes.EzSecurityToken securityToken
                          2: required string name
                          3: required i64 retentionDurationSeconds)
                        throws
                         (1: ezbakeBaseTypes.EzSecurityTokenException security
                          2: ProvenanceAgeOffRuleNotFoundException ruleNotFound
                          3: ProvenanceIllegalAgeOffDurationSecondsException illegalAgeOffDurationSeconds
                          4: ProvenanceIllegalAgeOffRuleNameException illegalAgeOffName)

    /*
    Returns the list of all AgeOffRules in the system. An empty list is returned if no rules exist.
    The list should be lexigraphically ordered by the AgeOffRule.name.
    If limit is set without page or page is set without limit, those arguments will be ignored.
    If both set, limit should be the maximum length of the returned list and the first element of the list should be at
      the limit * page offset within the full set of AgeOffRules.
    An empty list will be returned if page * limit exceeds the length of the full set of AgeOffRules.
    Throws the EzSecurityTokenException if the securityToken cannot be validated.
    */
    list<AgeOffRule> getAllAgeOffRules(1: required ezbakeBaseTypes.EzSecurityToken securityToken
                                       2: i32 limit
                                       3: i32 page)
                                     throws
                                      (1: ezbakeBaseTypes.EzSecurityTokenException security)

    /*
    Returns the count of age off rules registered with the provenance service.
    Throws an EzSecurityTokenException if the securityToken is invalid
    */
    i32 countAgeOffRules(1: required ezbakeBaseTypes.EzSecurityToken securityToken)
                       throws
                        (1: ezbakeBaseTypes.EzSecurityTokenException security)

    /*
    Allows any application in the system to add a document to the provenance service.
    The caller must specify the uri string that is unique to this piece of data throughout the system.
    A new Document vertex will be created for this document.
    Throws EzSecurityTokenException exception if the securityToken is invalid.
    Throws ProvenanceDocumentExistsException exception if the uri has already exists.
    Throws ProvenanceAgeOffRuleNotFoundException exception if the AgeOffRule cannot be found by the ruleId in the
      AgeOffMapping.ruleId in ageOffRules list.
    Throws ProvenanceParentDocumentNotFoundException exception if the parents Document cannot be found.
    Throws ProvenanceCircularInheritanceNotAllowedException exception if the document has itself as parent.
    Returns the generated DocumentId for the Document vertex.
    */
    i64 addDocument(1: required ezbakeBaseTypes.EzSecurityToken token
                    2: required string uri
                    3: list<InheritanceInfo> parents
                    4: list<AgeOffMapping> ageOffRules)
                  throws
                   (1: ezbakeBaseTypes.EzSecurityTokenException security
                    2: ProvenanceDocumentExistsException documentExists
                    3: ProvenanceAgeOffRuleNotFoundException ruleNotFound
                    4: ProvenanceParentDocumentNotFoundException parentNotFound
                    5: ProvenanceCircularInheritanceNotAllowedException circularInheritanceNotAllowed)

    /*
    Allows any application in the system to add documents to the provenance service.
    Throws EzSecurityTokenException exception if the securityToken is invalid.
    Throws ProvenanceAgeOffRuleNotFoundException exception if the AgeOffRule cannot be found by the ruleId in the
      AgeOffMapping.ruleId in ageOffRules list.
    Throws ProvenanceExceedsMaxBatchSizeException exception if the size of documents exceeds the max batch size.
      The max batch size defaults to 500 and is configurable.
    Returns the map of AddDocumentResult to each document URI in the documents set.
    */
    map<string, AddDocumentResult> addDocuments(1: required ezbakeBaseTypes.EzSecurityToken securityToken
                                                2: required set<AddDocumentEntry> documents
                                                3: set<AgeOffMapping> ageOffRules)
                                              throws
                                               (1: ezbakeBaseTypes.EzSecurityTokenException security
                                                2: ProvenanceAgeOffRuleNotFoundException ruleNotFound
                                                3: ProvenanceExceedsMaxBatchSizeException exceedsMaxSize)

    /*
    Allows to query the size limit to add documents in batch to the provenance service.
    Throws EzSecurityTokenException exception if the securityToken is invalid.
    Returns the configured batch size limit.
    */
    i32 getAddDocumentsMaxSize(1: required ezbakeBaseTypes.EzSecurityToken securityToken)
                             throws
                              (1: ezbakeBaseTypes.EzSecurityTokenException security)

    /*
     Allows admin applications to retrieve all DocumentIds evaluated to be aged against ageOffRule ruleId.
     Throws EzSecurityTokenException exception if the securityToken is invalid or the calling application is not Admin.
     Throws ProvenanceAgeOffRuleNotFoundException if the AgeOffRule cannot be found by the ruleId.
     Returns AgeOffInitiationResult.
     */
    AgeOffInitiationResult startAgeOffEvent(1: required ezbakeBaseTypes.EzSecurityToken securityToken,
                                            2: required i64 ruleId,
                                            3:  ezbakeBaseTypes.DateTime effectiveTime)
                                          throws
                                           (1: ezbakeBaseTypes.EzSecurityTokenException security,
                                            2: ProvenanceAgeOffRuleNotFoundException ruleNotFound)

    /*
    Allows to set the Aged property of the Document vertex defined in agedDocumentIds.
    Throws EzSecurityTokenException exception if the securityToken is invalid or the calling application is not Admin.
    Throws ProvenanceDocumentNotFoundException exception if the highest ID set is greater than the highest document ID
      in the system when agedDocumentIds is used.
    */
    void markDocumentAsAged(1: required ezbakeBaseTypes.EzSecurityToken securityToken,
                            2: required set<i64> agedDocumentIds)
                          throws
                           (1: ezbakeBaseTypes.EzSecurityTokenException security,
                            2: ProvenanceDocumentNotFoundException documentNotFound)

    /*
    Allows to retrieve properties of a Document vertex.
    If id is present, it should be used regardless of whether uri is present.
    Throws EzSecurityTokenException exception if the securityToken is invalid.
    Throws ProvenanceDocumentNotFoundException exception if neither id nore uri is present, or there is no corresponding document.
    */
    DocumentInfo getDocumentInfo(1: required ezbakeBaseTypes.EzSecurityToken securityToken,
                                 2: i64 id,
                                 3: string uri)
                                throws
                                 (1: ezbakeBaseTypes.EzSecurityTokenException security,
                                  2: ProvenanceDocumentNotFoundException docNotFound)

    /*
    Allows to retrieve all ancestors of the document URIs in the request list.
    Throws EzSecurityTokenException exception if the securityToken is invalid.
    */
    DerivedResult getDocumentAncestors(1: required ezbakeBaseTypes.EzSecurityToken securityToken,
                                       2: required list<string> uris)
                                     throws
                                      (1: ezbakeBaseTypes.EzSecurityTokenException security)

    /*
    Allows to retrieve all descendants of the document URIs in the request list.
    Throws EzSecurityTokenException exception if the securityToken is invalid.
    */
    DerivedResult getDocumentDescendants(1: required ezbakeBaseTypes.EzSecurityToken securityToken,
                                         2: required list<string> uris)
                                       throws
                                        (1: ezbakeBaseTypes.EzSecurityTokenException security)

    /*
    Allows to get the id of the documents and their descendants in the request uris list to be purged later.
    A PurgeEvent vertex will be created with optional name and description and the generated id
      will be returned in the PurgeInitiationResult.PurgeId.
    Throws EzSecurityTokenException exception if the securityToken is invalid or not an Admin application.
    */
    PurgeInitiationResult markDocumentForPurge(1: required ezbakeBaseTypes.EzSecurityToken securityToken,
                                               2: required list<string> uris,
                                               3: string name,
                                               4: string description)
                                             throws
                                              (1: ezbakeBaseTypes.EzSecurityTokenException security)

    /*
    Allows to retrieve the mapping Document URI from the id in the request positionsList.
    Throws EzSecurityTokenException exception if the securityToken is invalid.
    */
    PositionsToUris getDocumentUriFromId(1: required ezbakeBaseTypes.EzSecurityToken securityToken,
                                         2: required list<i64> positionsList)
                                       throws
                                        (1: ezbakeBaseTypes.EzSecurityTokenException security)

    /*
    Allows to get the IDs of the Document defined in ids set.
    The ids exist will be in ConversionResult.convertedUris while the ids not exist will be in ConversionResult.idsNotFound.
    Throws EzSecurityTokenException exception if the securityToken is invalid.
    */
    ConversionResult getDocumentConvertedUrisFromIds(1: required ezbakeBaseTypes.EzSecurityToken securityToken,
                                                     2: required set<i64> ids)
                                                   throws
                                                    (1: ezbakeBaseTypes.EzSecurityTokenException security)

    /*
    Allows to get the IDs of the Document defined in uris set.
    The uris exist will be in ConversionResult.convertedUris while the uris not exist will be in ConversionResult.urisNotFound.
    Throws EzSecurityTokenException exception if the securityToken is invalid.
    */
    ConversionResult getDocumentConvertedUrisFromUris(1: required ezbakeBaseTypes.EzSecurityToken securityToken,
                                                      2: required set<string> uris)
                                                    throws
                                                     (1: ezbakeBaseTypes.EzSecurityTokenException security)

    /*
    Allows to get purge information for the requested purgeId.
    Throws EzSecurityTokenException exception if the securityToken is invalid or the application is not purge app.
    Throws ProvenancePurgeIdNotFoundException exception if the requested purgeId not found.
    */
    PurgeInfo getPurgeInfo(1: required ezbakeBaseTypes.EzSecurityToken securityToken,
                           2: required i64 purgeId)
                         throws
                          (1: ezbakeBaseTypes.EzSecurityTokenException security,
                           2: ProvenancePurgeIdNotFoundException purgeNotFound)

    /*
    Allows to get the PurgeId of all PurgeEvent vertices.
    Throws EzSecurityTokenException exception if the securityToken is invalid or the application is not purge app.
    */
    list<i64> getAllPurgeIds(1: required ezbakeBaseTypes.EzSecurityToken securityToken)
                           throws
                            (1: ezbakeBaseTypes.EzSecurityTokenException security)

    /*
    Allows to update the PurgeEvent vertex properties.
    Throws EzSecurityTokenException exception if the securityToken is invalid or the application is not purge app.
    Throws ProvenancePurgeIdNotFoundException exception if the requested purgeId not found.
    Throws ProvenanceDocumentNotInPurgeException exception if any ID in completelyPurged is not in
     the PurgeEvent vertex's PurgeDocumentIds.
    */
    void updatePurge(1: required ezbakeBaseTypes.EzSecurityToken securityToken,
                     2: required i64 purgeId,
                     3: required set<i64> completelyPurged,
                     4: string note,
                     5: bool resolved)
                   throws
                    (1: ezbakeBaseTypes.EzSecurityTokenException security,
                     2: ProvenancePurgeIdNotFoundException purgeNotFound,
                     3: ProvenanceDocumentNotInPurgeException documentNotInPurge)

    /*
    Allows to remove the AgeOff inheritance of Document specified by documentId/documentUri from parent Document specified
     by parentId/parentUri.
    When both id/uri are specified, id will be used to find the Document.
    Throws EzSecurityTokenException exception if the securityToken is invalid.
    Throws ProvenanceDocumentNotFoundException exception if neither documentId nor documentUri is sepecified,
     or neither parentId or parentUri is sepcified, or the document/parent vertex not present.
    Throws ProvenanceAlreadyAgedException exception if the Aged property of the Document vertex is True.
    */
    void removeDocumentAgeOffRuleInheritance(1: required ezbakeBaseTypes.EzSecurityToken securityToken,
                                             2: i64 documentId,
                                             3: string documentUri,
                                             4: i64 parentId,
                                             5: string parentUri)
                                           throws
                                            (1: ezbakeBaseTypes.EzSecurityTokenException security,
                                             2: ProvenanceDocumentNotFoundException documentNotFound,
                                             3: ProvenanceAlreadyAgedException alreadyAged)

    /*
    Allows to remove any inbound AgeOff edges to Document specified by documentId/documentUri from the AgeOffRule vertex
     specified by ageOffRuleId.
    When both documentId/documentUri are specified, documentId will be used to find the Document.
    Throws EzSecurityTokenException exception if the securityToken is invalid.
    Throws ProvenanceDocumentNotFoundException exception if neither documentId nor documentUri is sepecified,
      or the Document vertex not found.
    Throws ProvenanceAgeOffRuleNotFoundException exception if AgeOffRule vertex not found.
    Throws ProvenanceAlreadyAgedException exception if the Aged property of the Document vertex is True.
    */
    void removeDocumentExplicitAgeOffRule(1: required ezbakeBaseTypes.EzSecurityToken securityToken,
                                          2: i64 documentId,
                                          3: string documentUri,
                                          4: required i64 ageOffRuleId,)
                                        throws
                                         (1: ezbakeBaseTypes.EzSecurityTokenException security,
                                          2: ProvenanceDocumentNotFoundException documentNotFound,
                                          3: ProvenanceAgeOffRuleNotFoundException ruleNotFound
                                          4: ProvenanceAlreadyAgedException alreadyAged)

    /*
    Allows to add an AgeOff edge from the AgeOffRule vertex specified by ageOffMapping.ruleId to the Document vertex
      specified by documentId/documentUri.
    When both documentId/documentUri are specified, documentId will be used to find the Document.
    Throws EzSecurityTokenException exception if the securityToken is invalid.
    Throws ProvenanceDocumentNotFoundException exception if neither documentId nor documentUri is sepecified,
      or the Document vertex not present.
    Throws ProvenanceAgeOffRuleNotFoundException exception if the AgeOffRule vertex not found.
    Throws ProvenanceAlreadyAgedException exception if the Aged property of the Document vertex is True.
    Throws ProvenanceAgeOffExistsException exception if Document already has inbound AgeOff edge from this AgeOffRule.
    */
    void addDocumentExplicitAgeOffRule(1: required ezbakeBaseTypes.EzSecurityToken securityToken,
                                       2: i64 documentId,
                                       3: string documentUri,
                                       4: required AgeOffMapping ageOffMapping)
                                     throws
                                      (1: ezbakeBaseTypes.EzSecurityTokenException security,
                                       2: ProvenanceDocumentNotFoundException documentNotFound,
                                       3: ProvenanceAgeOffRuleNotFoundException ruleNotFound,
                                       4: ProvenanceAlreadyAgedException alreadyAged,
                                       5: ProvenanceAgeOffExistsException edgeExists)

    /*
    Allows to add derived from relation to the Document specified by documentId/documentUri from the parent Document
      specified by inheritanceInfo.parentUri.
    When both documentId/documentUri are specified, documentId will be used to find the Document.
    Throws EzSecurityTokenException exception if the securityToken is invalid.
    Throws ProvenanceDocumentNotFoundException exception if neither documentId nor documentUri is sepecified,
      or the Document vertex not found, or the inheritanceInfo.parentUri Document vertex not found.
    Throws ProvenanceCircularInheritanceNotAllowedException exception if adding the new inheritance will cause
      circular inheritance relationship.
    Throws ProvenanceAlreadyAgedException exception if the Aged property of the Document vertex is True.
    Throws ProvananceAgeOffInheritanceExistsException exception if the Document InheritanceInfo property already
      contains a rule with the inheritanceInfo.parentUri.
    */
    void addDocumentInheritanceInfo(1: required ezbakeBaseTypes.EzSecurityToken securityToken,
                                    2: i64 documentId,
                                    3: string documentUri,
                                    4: required InheritanceInfo inheritanceInfo)
                                  throws
                                   (1: ezbakeBaseTypes.EzSecurityTokenException security,
                                    2: ProvenanceDocumentNotFoundException documentNotFound,
                                    3: ProvenanceCircularInheritanceNotAllowedException circularInheritance,
                                    4: ProvenanceAlreadyAgedException alreadyAged,
                                    5: ProvenanceAgeOffInheritanceExistsException  inheritanceExists)
    /*
    Allows an application to record the fact that a user has viewed a document specified
    by the document URI. The serivice will record that the user using the requesting
    application viewed the specified document. This information is time-stamped
    with the time at which the service receives the request.
    */
    void recordObjectAccess(1: required ezbakeBaseTypes.EzSecurityToken securityToken,
                            2: required string documentUri
                            3: required ObjectAccessType accessType)
                          throws
                           (1: ezbakeBaseTypes.EzSecurityTokenException security,)


   /*
   Allows an application to fetch the documents accessed by a user

   There may be a lot of results. numToFetch must be between 0 and 10,000. Specifying 0 will
   retrieve 0 results. Specifying more than 10,000 will simply result in at most 10,000 results
   being returned.

   Because there could be far more than 10,000 results, this method supports pseudo-cursor
   like access. The resultsAndContinuation return structure contains a continuationPoint
   member. To fetch the next set of results, use that continuationPoint as the continuationPoint
   argument for this method.

   No true paging is supported, though a client could reuse continuationPoints to step back
   to previous pages.

   continuationPoint should be set to an empty string to fetch the initial set of results.
   */
   ResultsAndContinuation fetchUsersDocuments(1:  ezbakeBaseTypes.EzSecurityToken securityToken,
                                              2:  string userPrincipal,
                                              3:  ezbakeBaseTypes.DateTime startDateTime,
                                              4:  ezbakeBaseTypes.DateTime stopDateTime,
                                              5:  i32 numToFetch,
                                              6:  AccumuloContinuationPoint continuationPoint)
                                            throws
                                             (1: ezbakeBaseTypes.EzSecurityTokenException security,)

   /*
   Allows an application to fetch the documents accessed by a user

   There may be a lot of results. numToFetch must be between 0 and 10,000. Specifying 0 will
   retrieve 0 results. Specifying more than 10,000 will simply result in at most 10,000 results
   being returned.

   Because there could be far more than 10,000 results, this method supports pseudo-cursor
   like access. The resultsAndContinuation return structure contains a continuationPoint
   member. To fetch the next set of results, use that continuationPoint as the continuationPoint
   argument for this method.

   No true paging is supported, though a client could reuse continuationPoints to step back
   to previous pages.

   continuationPoint should be set to an empty string to fetch the initial set of results.
   */
   ResultsAndContinuation fetchDocumentUsers(1:  ezbakeBaseTypes.EzSecurityToken securityToken,
                                             2:  string documentUri,
                                             3:  ezbakeBaseTypes.DateTime startDateTime,
                                             4:  ezbakeBaseTypes.DateTime stopDateTime,
                                             5:  i32 numToFetch,
                                             6:  AccumuloContinuationPoint continuationPoint)
                                           throws
                                            (1: ezbakeBaseTypes.EzSecurityTokenException security,)
}
