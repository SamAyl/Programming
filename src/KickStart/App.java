package KickStart;

public class App {

    public static void main(String[] args) {
        String s ="{\"id\":\"a1o1I0000011zxFQAQ\",\"processTitle\":\"Manage Work Order Lines  -Formula\",\"processId\":\"Manage_Work_Order_Lines___Formula\",\"ruleType\":\"Interactive\",\"pageLayoutId\":\"a0f1I000001fsvBQAQ\",\"processType\":\"STANDALONE EDIT\",\"enableSubProcess\":false,\"processNodeObjects\":[{\"id\":\"a1o1I0000011zxtQAA\",\"sfmProcessId\":\"a1o1I0000011zxFQAQ\",\"sourceObjectName\":\"SVMXC__Service_Order__c\",\"type\":\"TARGET\",\"sequence\":0.0,\"enableAttachment\":false},{\"id\":\"a1o1I0000011zxuQAA\",\"sfmProcessId\":\"a1o1I0000011zxFQAQ\",\"sourceObjectName\":\"SVMXC__Service_Order_Line__c\",\"type\":\"TARGETCHILD\",\"nodeParentAPI\":\"SVMXC__Service_Order__c\",\"sequence\":1.0,\"pageLayoutId\":\"a0f1I000001fsvCQAQ\",\"enableAttachment\":false,\"parentColumn\":\"SVMXC__Service_Order__c\"}],\"pageUI\":{\"id\":\"a0f1I000001fsvBQAQ\",\"allowDeleteLines\":false,\"allowNewLines\":false,\"enableAttachments\":false,\"enableChatter\":false,\"enableServiceReportGeneration\":false,\"enableServiceReportView\":false,\"enableTroubleshooting\":false,\"helpURL\":\"http://userdocs.servicemax.com:8080/ServiceMaxHelp/Spring18/en_us/svmx_redirector.htm?uid=SFM|HowToUseSFMDelivery\",\"hideQuickSave\":false,\"hideSave\":false,\"name\":\"Formula-001\",\"noOfColumns\":0,\"objectName\":\"SVMXC__Service_Order__c\",\"pageLayoutId\":\"Formula-001\",\"promptForNewEvent\":false,\"sequence\":0.0,\"showAccountHistory\":false,\"showAllSectionsByDefault\":true,\"showProductHistory\":false,\"type\":\"Header\",\"sections\":[{\"id\":\"a0e1I000005lYeFQAU\",\"detailType\":\"Section\",\"displayColumn\":0,\"displayRow\":0,\"overrideRelatedLookup\":false,\"readOnly\":false,\"required\":false,\"showIniPad\":false,\"showInWeb\":false,\"title\":\"Work Order\",\"isStandard\":false,\"sequence\":1.0,\"pageLayout\":\"a0f1I000001fsvBQAQ\",\"noOfColumns\":2.0,\"useForSLAClock\":false,\"fields\":[{\"id\":\"a0e1I000005lYeGQAU\",\"controlType\":\"Standard\",\"dataType\":\"reference\",\"detailType\":\"Field\",\"displayColumn\":1.0,\"displayRow\":1.0,\"fieldApiName\":\"SVMXC__Company__c\",\"lookupId\":\"a1o1I000000pFNYQA2\",\"name\":\"0000001723\",\"overrideRelatedLookup\":false,\"relatedObjectNameField\":\"Name\",\"readOnly\":false,\"relatedObjectName\":\"Account\",\"required\":false,\"section\":\"a0e1I000005lYeFQAU\",\"showIniPad\":false,\"showInWeb\":false,\"isStandard\":false,\"sequence\":1.0,\"pageLayout\":\"a0f1I000001fsvBQAQ\",\"noOfColumns\":0,\"lookup\":{\"id\":\"a1o1I000000pFNYQA2\",\"processId\":\"LKP005\",\"description\":\"Pre-configured standard lookup for Account object\",\"sourceObjectName\":\"Account\",\"noOfLookupRecords\":10.0,\"defaultLookupColumn\":\"Name\",\"ruleType\":\"SRCH_LOOKUP_CONFIG\",\"recordTypeId\":\"0121I000000ZGZeQAO\",\"lookupObjects\":[{\"id\":\"a1o1I000000pFO0QAM\",\"processId\":\"LKP005_Account\",\"sourceObjectName\":\"Account\",\"ruleType\":\"SRCH_OBJECT\",\"module\":\"a1o1I000000pFNYQA2\",\"sequence\":5.0,\"defaultOn\":false,\"allowOverride\":false,\"recordTypeId\":\"0121I000000ZGZeQAO\",\"objectFields\":[{\"expressionRule\":\"a1o1I000000pFO0QAM\",\"expressionType\":\"SRCH_Object_Fields\",\"sequence\":1.0,\"fieldName\":\"Name\",\"searchObjectFieldType\":\"Search\",\"isNameField\":false,\"sortOrder\":\"Ascending\",\"recordTypeId\":\"0121I000000ZGZ9QAO\"},{\"expressionRule\":\"a1o1I000000pFO0QAM\",\"expressionType\":\"SRCH_Object_Fields\",\"sequence\":2.0,\"fieldName\":\"AccountNumber\",\"searchObjectFieldType\":\"Search\",\"isNameField\":false,\"sortOrder\":\"Ascending\",\"recordTypeId\":\"0121I000000ZGZ9QAO\"},{\"expressionRule\":\"a1o1I000000pFO0QAM\",\"expressionType\":\"SRCH_Object_Fields\",\"sequence\":3.0,\"fieldName\":\"Phone\",\"searchObjectFieldType\":\"Search\",\"isNameField\":false,\"sortOrder\":\"Ascending\",\"recordTypeId\":\"0121I000000ZGZ9QAO\"},{\"expressionRule\":\"a1o1I000000pFO0QAM\",\"expressionType\":\"SRCH_Object_Fields\",\"sequence\":1.0,\"fieldName\":\"Name\",\"searchObjectFieldType\":\"Result\",\"isNameField\":false,\"sortOrder\":\"Ascending\",\"recordTypeId\":\"0121I000000ZGZ9QAO\"},{\"expressionRule\":\"a1o1I000000pFO0QAM\",\"expressionType\":\"SRCH_Object_Fields\",\"sequence\":2.0,\"fieldName\":\"Phone\",\"searchObjectFieldType\":\"Result\",\"isNameField\":false,\"sortOrder\":\"Ascending\",\"recordTypeId\":\"0121I000000ZGZ9QAO\"},{\"expressionRule\":\"a1o1I000000pFO0QAM\",\"expressionType\":\"SRCH_Object_Fields\",\"sequence\":1.0,\"fieldName\":\"Name\",\"searchObjectFieldType\":\"Bubble\",\"isNameField\":false,\"sortOrder\":\"Ascending\",\"recordTypeId\":\"0121I000000ZGZ9QAO\"},{\"expressionRule\":\"a1o1I000000pFO0QAM\",\"expressionType\":\"SRCH_Object_Fields\",\"sequence\":2.0,\"fieldName\":\"Phone\",\"searchObjectFieldType\":\"Bubble\",\"isNameField\":false,\"sortOrder\":\"Ascending\",\"recordTypeId\":\"0121I000000ZGZ9QAO\"}]}]}},{\"id\":\"a0e1I000005lYeHQAU\",\"controlType\":\"Standard\",\"dataType\":\"reference\",\"detailType\":\"Field\",\"displayColumn\":2.0,\"displayRow\":1.0,\"fieldApiName\":\"SVMXC__Contact__c\",\"lookupId\":\"a1o1I000000pFNXQA2\",\"name\":\"0000001724\",\"overrideRelatedLookup\":false,\"relatedObjectNameField\":\"Name\",\"readOnly\":false,\"relatedObjectName\":\"Contact\",\"required\":false,\"section\":\"a0e1I000005lYeFQAU\",\"showIniPad\":false,\"showInWeb\":false,\"isStandard\":false,\"sequence\":2.0,\"pageLayout\":\"a0f1I000001fsvBQAQ\",\"noOfColumns\":0,\"lookup\":{\"id\":\"a1o1I000000pFNXQA2\",\"processId\":\"LKP004\",\"description\":\"Pre-configured standard lookup for Contact object\",\"sourceObjectName\":\"Contact\",\"noOfLookupRecords\":10.0,\"defaultLookupColumn\":\"Name\",\"ruleType\":\"SRCH_LOOKUP_CONFIG\",\"recordTypeId\":\"0121I000000ZGZeQAO\",\"lookupObjects\":[{\"id\":\"a1o1I000000pFNzQAM\",\"processId\":\"LKP004_Contact\",\"sourceObjectName\":\"Contact\",\"ruleType\":\"SRCH_OBJECT\",\"module\":\"a1o1I000000pFNXQA2\",\"sequence\":4.0,\"defaultOn\":false,\"allowOverride\":false,\"recordTypeId\":\"0121I000000ZGZeQAO\",\"objectFields\":[{\"expressionRule\":\"a1o1I000000pFNzQAM\",\"expressionType\":\"SRCH_Object_Fields\",\"sequence\":1.0,\"fieldName\":\"Name\",\"searchObjectFieldType\":\"Search\",\"isNameField\":false,\"sortOrder\":\"Ascending\",\"recordTypeId\":\"0121I000000ZGZ9QAO\"},{\"expressionRule\":\"a1o1I000000pFNzQAM\",\"expressionType\":\"SRCH_Object_Fields\",\"sequence\":2.0,\"fieldName\":\"Phone\",\"searchObjectFieldType\":\"Search\",\"isNameField\":false,\"sortOrder\":\"Ascending\",\"recordTypeId\":\"0121I000000ZGZ9QAO\"},{\"expressionRule\":\"a1o1I000000pFNzQAM\",\"expressionType\":\"SRCH_Object_Fields\",\"sequence\":3.0,\"fieldName\":\"MobilePhone\",\"searchObjectFieldType\":\"Search\",\"isNameField\":false,\"sortOrder\":\"Ascending\",\"recordTypeId\":\"0121I000000ZGZ9QAO\"},{\"expressionRule\":\"a1o1I000000pFNzQAM\",\"expressionType\":\"SRCH_Object_Fields\",\"sequence\":4.0,\"fieldName\":\"Email\",\"searchObjectFieldType\":\"Search\",\"isNameField\":false,\"sortOrder\":\"Ascending\",\"recordTypeId\":\"0121I000000ZGZ9QAO\"},{\"expressionRule\":\"a1o1I000000pFNzQAM\",\"expressionType\":\"SRCH_Object_Fields\",\"sequence\":1.0,\"fieldName\":\"Name\",\"searchObjectFieldType\":\"Result\",\"isNameField\":false,\"sortOrder\":\"Ascending\",\"recordTypeId\":\"0121I000000ZGZ9QAO\"},{\"expressionRule\":\"a1o1I000000pFNzQAM\",\"expressionType\":\"SRCH_Object_Fields\",\"sequence\":2.0,\"objectName\":\"Account\",\"fieldName\":\"AccountId\",\"displayType\":\"REFERENCE\",\"fieldRelationshipName\":\"Account\",\"searchObjectFieldType\":\"Result\",\"isNameField\":false,\"sortOrder\":\"Ascending\",\"recordTypeId\":\"0121I000000ZGZ9QAO\"},{\"expressionRule\":\"a1o1I000000pFNzQAM\",\"expressionType\":\"SRCH_Object_Fields\",\"sequence\":3.0,\"fieldName\":\"Phone\",\"searchObjectFieldType\":\"Result\",\"isNameField\":false,\"sortOrder\":\"Ascending\",\"recordTypeId\":\"0121I000000ZGZ9QAO\"},{\"expressionRule\":\"a1o1I000000pFNzQAM\",\"expressionType\":\"SRCH_Object_Fields\",\"sequence\":4.0,\"fieldName\":\"Email\",\"searchObjectFieldType\":\"Result\",\"isNameField\":false,\"sortOrder\":\"Ascending\",\"recordTypeId\":\"0121I000000ZGZ9QAO\"},{\"expressionRule\":\"a1o1I000000pFNzQAM\",\"expressionType\":\"SRCH_Object_Fields\",\"sequence\":1.0,\"fieldName\":\"Name\",\"searchObjectFieldType\":\"Bubble\",\"isNameField\":false,\"sortOrder\":\"Ascending\",\"recordTypeId\":\"0121I000000ZGZ9QAO\"},{\"expressionRule\":\"a1o1I000000pFNzQAM\",\"expressionType\":\"SRCH_Object_Fields\",\"sequence\":2.0,\"fieldName\":\"Phone\",\"searchObjectFieldType\":\"Bubble\",\"isNameField\":false,\"sortOrder\":\"Ascending\",\"recordTypeId\":\"0121I000000ZGZ9QAO\"}]}]}},{\"id\":\"a0e1I000005lYeIQAU\",\"controlType\":\"Standard\",\"dataType\":\"reference\",\"detailType\":\"Field\",\"displayColumn\":1.0,\"displayRow\":2.0,\"fieldApiName\":\"SVMXC__Site__c\",\"lookupId\":\"a1o1I000000pFNVQA2\",\"name\":\"0000001725\",\"overrideRelatedLookup\":false,\"relatedObjectNameField\":\"Name\",\"readOnly\":false,\"relatedObjectName\":\"SVMXC__Site__c\",\"required\":false,\"section\":\"a0e1I000005lYeFQAU\",\"showIniPad\":false,\"showInWeb\":false,\"isStandard\":false,\"sequence\":3.0,\"pageLayout\":\"a0f1I000001fsvBQAQ\",\"noOfColumns\":0,\"lookup\":{\"id\":\"a1o1I000000pFNVQA2\",\"processId\":\"LKP002\",\"description\":\"Pre-configured standard lookup for Location object\",\"sourceObjectName\":\"SVMXC__Site__c\",\"noOfLookupRecords\":10.0,\"defaultLookupColumn\":\"Name\",\"ruleType\":\"SRCH_LOOKUP_CONFIG\",\"recordTypeId\":\"0121I000000ZGZeQAO\",\"lookupObjects\":[{\"id\":\"a1o1I000000pFNxQAM\",\"processId\":\"LKP002_SVMXC__Site__c\",\"sourceObjectName\":\"SVMXC__Site__c\",\"ruleType\":\"SRCH_OBJECT\",\"module\":\"a1o1I000000pFNVQA2\",\"sequence\":2.0,\"defaultOn\":false,\"allowOverride\":false,\"recordTypeId\":\"0121I000000ZGZeQAO\",\"objectFields\":[{\"expressionRule\":\"a1o1I000000pFNxQAM\",\"expressionType\":\"SRCH_Object_Fields\",\"sequence\":1.0,\"fieldName\":\"SVMXC__City__c\",\"searchObjectFieldType\":\"Search\",\"isNameField\":false,\"sortOrder\":\"Ascending\",\"recordTypeId\":\"0121I000000ZGZ9QAO\"},{\"expressionRule\":\"a1o1I000000pFNxQAM\",\"expressionType\":\"SRCH_Object_Fields\",\"sequence\":2.0,\"fieldName\":\"SVMXC__Country__c\",\"searchObjectFieldType\":\"Search\",\"isNameField\":false,\"sortOrder\":\"Ascending\",\"recordTypeId\":\"0121I000000ZGZ9QAO\"},{\"expressionRule\":\"a1o1I000000pFNxQAM\",\"expressionType\":\"SRCH_Object_Fields\",\"sequence\":3.0,\"fieldName\":\"Name\",\"searchObjectFieldType\":\"Search\",\"isNameField\":false,\"sortOrder\":\"Ascending\",\"recordTypeId\":\"0121I000000ZGZ9QAO\"},{\"expressionRule\":\"a1o1I000000pFNxQAM\",\"expressionType\":\"SRCH_Object_Fields\",\"sequence\":1.0,\"fieldName\":\"Name\",\"searchObjectFieldType\":\"Result\",\"isNameField\":false,\"sortOrder\":\"Ascending\",\"recordTypeId\":\"0121I000000ZGZ9QAO\"},{\"expressionRule\":\"a1o1I000000pFNxQAM\",\"expressionType\":\"SRCH_Object_Fields\",\"sequence\":2.0,\"fieldName\":\"SVMXC__City__c\",\"searchObjectFieldType\":\"Result\",\"isNameField\":false,\"sortOrder\":\"Ascending\",\"recordTypeId\":\"0121I000000ZGZ9QAO\"},{\"expressionRule\":\"a1o1I000000pFNxQAM\",\"expressionType\":\"SRCH_Object_Fields\",\"sequence\":3.0,\"fieldName\":\"SVMXC__Country__c\",\"searchObjectFieldType\":\"Result\",\"isNameField\":false,\"sortOrder\":\"Ascending\",\"recordTypeId\":\"0121I000000ZGZ9QAO\"},{\"expressionRule\":\"a1o1I000000pFNxQAM\",\"expressionType\":\"SRCH_Object_Fields\",\"sequence\":1.0,\"fieldName\":\"Name\",\"searchObjectFieldType\":\"Bubble\",\"isNameField\":false,\"sortOrder\":\"Ascending\",\"recordTypeId\":\"0121I000000ZGZ9QAO\"},{\"expressionRule\":\"a1o1I000000pFNxQAM\",\"expressionType\":\"SRCH_Object_Fields\",\"sequence\":2.0,\"fieldName\":\"SVMXC__City__c\",\"searchObjectFieldType\":\"Bubble\",\"isNameField\":false,\"sortOrder\":\"Ascending\",\"recordTypeId\":\"0121I000000ZGZ9QAO\"},{\"expressionRule\":\"a1o1I000000pFNxQAM\",\"expressionType\":\"SRCH_Object_Fields\",\"sequence\":3.0,\"fieldName\":\"SVMXC__Country__c\",\"searchObjectFieldType\":\"Bubble\",\"isNameField\":false,\"sortOrder\":\"Ascending\",\"recordTypeId\":\"0121I000000ZGZ9QAO\"}]}]}},{\"id\":\"a0e1I000005lYeJQAU\",\"controlType\":\"Standard\",\"dataType\":\"textarea\",\"detailType\":\"Field\",\"displayColumn\":2.0,\"displayRow\":2.0,\"fieldApiName\":\"SVMXC__Problem_Description__c\",\"name\":\"0000001726\",\"overrideRelatedLookup\":false,\"readOnly\":false,\"required\":false,\"section\":\"a0e1I000005lYeFQAU\",\"showIniPad\":false,\"showInWeb\":false,\"isStandard\":false,\"sequence\":4.0,\"pageLayout\":\"a0f1I000001fsvBQAQ\",\"noOfColumns\":0},{\"id\":\"a0e1I000005lYeKQAU\",\"controlType\":\"Standard\",\"dataType\":\"picklist\",\"detailType\":\"Field\",\"displayColumn\":1.0,\"displayRow\":3.0,\"fieldApiName\":\"SVMXC__Billing_Type__c\",\"name\":\"0000001727\",\"overrideRelatedLookup\":false,\"readOnly\":false,\"required\":false,\"section\":\"a0e1I000005lYeFQAU\",\"showIniPad\":false,\"showInWeb\":false,\"isStandard\":false,\"sequence\":5.0,\"pageLayout\":\"a0f1I000001fsvBQAQ\",\"noOfColumns\":0},{\"id\":\"a0e1I000005lYeLQAU\",\"controlType\":\"Standard\",\"dataType\":\"textarea\",\"detailType\":\"Field\",\"displayColumn\":2.0,\"displayRow\":3.0,\"fieldApiName\":\"SVMXC__Work_Performed__c\",\"name\":\"0000001728\",\"overrideRelatedLookup\":false,\"readOnly\":false,\"required\":false,\"section\":\"a0e1I000005lYeFQAU\",\"showIniPad\":false,\"showInWeb\":false,\"isStandard\":false,\"sequence\":6.0,\"pageLayout\":\"a0f1I000001fsvBQAQ\",\"noOfColumns\":0},{\"id\":\"a0e1I000005lYeMQAU\",\"controlType\":\"Standard\",\"dataType\":\"currency\",\"detailType\":\"Field\",\"displayColumn\":1.0,\"displayRow\":4.0,\"fieldApiName\":\"SVMXC__Proforma_Invoice_Amount__c\",\"name\":\"0000001729\",\"overrideRelatedLookup\":false,\"readOnly\":false,\"required\":false,\"section\":\"a0e1I000005lYeFQAU\",\"showIniPad\":false,\"showInWeb\":false,\"isStandard\":false,\"sequence\":7.0,\"pageLayout\":\"a0f1I000001fsvBQAQ\",\"noOfColumns\":0}]}],\"details\":[{\"id\":\"a0f1I000001fsvCQAQ\",\"allowDeleteLines\":false,\"allowNewLines\":false,\"enableAttachments\":false,\"enableChatter\":false,\"enableServiceReportGeneration\":false,\"enableServiceReportView\":false,\"enableTroubleshooting\":false,\"headerPageLayout\":\"a0f1I000001fsvBQAQ\",\"hideQuickSave\":false,\"hideSave\":false,\"name\":\"Work Detail (Work Order)\",\"noOfColumns\":0,\"objectName\":\"SVMXC__Service_Order_Line__c\",\"pageLayoutId\":\"Work Detail (Work Order)\",\"promptForNewEvent\":false,\"sequence\":1.0,\"showAccountHistory\":false,\"showAllSectionsByDefault\":false,\"showProductHistory\":false,\"type\":\"Detail\",\"fields\":[{\"id\":\"a0e1I000005lYeNQAU\",\"controlType\":\"Standard\",\"dataType\":\"double\",\"detailType\":\"Field\",\"displayColumn\":1.0,\"displayRow\":0.0,\"fieldApiName\":\"SVMXC__Billable_Quantity__c\",\"overrideRelatedLookup\":false,\"readOnly\":false,\"required\":false,\"showIniPad\":false,\"showInWeb\":false,\"isStandard\":false,\"sequence\":1.0,\"pageLayout\":\"a0f1I000001fsvCQAQ\",\"noOfColumns\":0},{\"id\":\"a0e1I000005lYeOQAU\",\"controlType\":\"Standard\",\"dataType\":\"double\",\"detailType\":\"Field\",\"displayColumn\":2.0,\"displayRow\":0.0,\"fieldApiName\":\"SVMXC__Actual_Quantity2__c\",\"overrideRelatedLookup\":false,\"readOnly\":false,\"required\":false,\"showIniPad\":false,\"showInWeb\":false,\"isStandard\":false,\"sequence\":2.0,\"pageLayout\":\"a0f1I000001fsvCQAQ\",\"noOfColumns\":0},{\"id\":\"a0e1I000005lYePQAU\",\"contextSourceObject\":\"CURRENT_RECORD\",\"controlType\":\"Standard\",\"dataType\":\"reference\",\"detailType\":\"Field\",\"displayColumn\":3.0,\"displayRow\":0.0,\"fieldApiName\":\"SVMXC__Product__c\",\"lookupId\":\"a1o1I000000pFNUQA2\",\"overrideRelatedLookup\":false,\"relatedObjectNameField\":\"Name\",\"readOnly\":false,\"relatedObjectName\":\"Product2\",\"required\":false,\"showIniPad\":false,\"showInWeb\":false,\"isStandard\":false,\"sequence\":3.0,\"pageLayout\":\"a0f1I000001fsvCQAQ\",\"noOfColumns\":0,\"lookup\":{\"id\":\"a1o1I000000pFNUQA2\",\"processId\":\"LKP001\",\"description\":\"Pre-configured standard lookup for Product object\",\"sourceObjectName\":\"Product2\",\"noOfLookupRecords\":10.0,\"defaultLookupColumn\":\"Name\",\"ruleType\":\"SRCH_LOOKUP_CONFIG\",\"recordTypeId\":\"0121I000000ZGZeQAO\",\"lookupObjects\":[{\"id\":\"a1o1I000000pFNwQAM\",\"processId\":\"LKP001_Product2\",\"sourceObjectName\":\"Product2\",\"ruleType\":\"SRCH_OBJECT\",\"module\":\"a1o1I000000pFNUQA2\",\"sequence\":1.0,\"defaultOn\":false,\"allowOverride\":false,\"recordTypeId\":\"0121I000000ZGZeQAO\",\"objectFields\":[{\"expressionRule\":\"a1o1I000000pFNwQAM\",\"expressionType\":\"SRCH_Object_Fields\",\"sequence\":1.0,\"fieldName\":\"Name\",\"searchObjectFieldType\":\"Search\",\"isNameField\":false,\"sortOrder\":\"Ascending\",\"recordTypeId\":\"0121I000000ZGZ9QAO\"},{\"expressionRule\":\"a1o1I000000pFNwQAM\",\"expressionType\":\"SRCH_Object_Fields\",\"sequence\":2.0,\"fieldName\":\"ProductCode\",\"searchObjectFieldType\":\"Search\",\"isNameField\":false,\"sortOrder\":\"Ascending\",\"recordTypeId\":\"0121I000000ZGZ9QAO\"},{\"expressionRule\":\"a1o1I000000pFNwQAM\",\"expressionType\":\"SRCH_Object_Fields\",\"sequence\":3.0,\"fieldName\":\"Family\",\"searchObjectFieldType\":\"Search\",\"isNameField\":false,\"sortOrder\":\"Ascending\",\"recordTypeId\":\"0121I000000ZGZ9QAO\"},{\"expressionRule\":\"a1o1I000000pFNwQAM\",\"expressionType\":\"SRCH_Object_Fields\",\"sequence\":1.0,\"fieldName\":\"Name\",\"searchObjectFieldType\":\"Result\",\"isNameField\":false,\"sortOrder\":\"Ascending\",\"recordTypeId\":\"0121I000000ZGZ9QAO\"},{\"expressionRule\":\"a1o1I000000pFNwQAM\",\"expressionType\":\"SRCH_Object_Fields\",\"sequence\":2.0,\"fieldName\":\"ProductCode\",\"searchObjectFieldType\":\"Result\",\"isNameField\":false,\"sortOrder\":\"Ascending\",\"recordTypeId\":\"0121I000000ZGZ9QAO\"},{\"expressionRule\":\"a1o1I000000pFNwQAM\",\"expressionType\":\"SRCH_Object_Fields\",\"sequence\":3.0,\"fieldName\":\"Family\",\"searchObjectFieldType\":\"Result\",\"isNameField\":false,\"sortOrder\":\"Ascending\",\"recordTypeId\":\"0121I000000ZGZ9QAO\"},{\"expressionRule\":\"a1o1I000000pFNwQAM\",\"expressionType\":\"SRCH_Object_Fields\",\"sequence\":1.0,\"fieldName\":\"Name\",\"searchObjectFieldType\":\"Bubble\",\"isNameField\":false,\"sortOrder\":\"Ascending\",\"recordTypeId\":\"0121I000000ZGZ9QAO\"},{\"expressionRule\":\"a1o1I000000pFNwQAM\",\"expressionType\":\"SRCH_Object_Fields\",\"sequence\":2.0,\"fieldName\":\"ProductCode\",\"searchObjectFieldType\":\"Bubble\",\"isNameField\":false,\"sortOrder\":\"Ascending\",\"recordTypeId\":\"0121I000000ZGZ9QAO\"},{\"expressionRule\":\"a1o1I000000pFNwQAM\",\"expressionType\":\"SRCH_Object_Fields\",\"sequence\":3.0,\"fieldName\":\"Family\",\"searchObjectFieldType\":\"Bubble\",\"isNameField\":false,\"sortOrder\":\"Ascending\",\"recordTypeId\":\"0121I000000ZGZ9QAO\"},{\"expressionRule\":\"a1o1I000000pFNwQAM\",\"expressionType\":\"SRCH_Object_Fields\",\"sequence\":4.0,\"fieldName\":\"SVMXC__Product_Line__c\",\"searchObjectFieldType\":\"Search\",\"isNameField\":false,\"sortOrder\":\"Ascending\",\"recordTypeId\":\"0121I000000ZGZ9QAO\"},{\"expressionRule\":\"a1o1I000000pFNwQAM\",\"expressionType\":\"SRCH_Object_Fields\",\"sequence\":4.0,\"fieldName\":\"SVMXC__Product_Line__c\",\"searchObjectFieldType\":\"Result\",\"isNameField\":false,\"sortOrder\":\"Ascending\",\"recordTypeId\":\"0121I000000ZGZ9QAO\"},{\"expressionRule\":\"a1o1I000000pFNwQAM\",\"expressionType\":\"SRCH_Object_Fields\",\"sequence\":4.0,\"fieldName\":\"SVMXC__Product_Line__c\",\"searchObjectFieldType\":\"Bubble\",\"isNameField\":false,\"sortOrder\":\"Ascending\",\"recordTypeId\":\"0121I000000ZGZ9QAO\"}]},{\"id\":\"a1o1I000000pFONQA2\",\"processId\":\"LKP001_SVMXC__Product_Stock__c\",\"name\":\"SVMXSTD:Limit Items to My Trunk Stock\",\"description\":\"Limit Items to My Trunk Stock\",\"sourceObjectName\":\"SVMXC__Product_Stock__c\",\"parentObjectCriteria\":\"SVMXC__Status__c='Available'  AND  SVMXC__Available_Qty__c>0  AND  SVMXC__Location__c='SVMX.USERTRUNK'\",\"ruleType\":\"SRCH_CRITERIA\",\"module\":\"a1o1I000000pFNUQA2\",\"fieldName\":\"SVMXC__Product__c\",\"sequence\":0.0,\"defaultOn\":false,\"allowOverride\":true,\"recordTypeId\":\"0121I000000ZGZeQAO\",\"objectFields\":[{\"expressionRule\":\"a1o1I000000pFONQA2\",\"expressionType\":\"LKUP_Criteria\",\"sequence\":1.0,\"fieldName\":\"SVMXC__Status__c\",\"operator\":\"eq\",\"operand\":\"Available\",\"isNameField\":false,\"parameterType\":\"Value\",\"sortOrder\":\"Ascending\",\"recordTypeId\":\"0121I000000ZGZ9QAO\"},{\"expressionRule\":\"a1o1I000000pFONQA2\",\"expressionType\":\"LKUP_Criteria\",\"sequence\":2.0,\"fieldName\":\"SVMXC__Available_Qty__c\",\"operator\":\"gt\",\"operand\":\"0\",\"isNameField\":false,\"parameterType\":\"Value\",\"sortOrder\":\"Ascending\",\"recordTypeId\":\"0121I000000ZGZ9QAO\"},{\"expressionRule\":\"a1o1I000000pFONQA2\",\"expressionType\":\"LKUP_Criteria\",\"sequence\":3.0,\"fieldName\":\"SVMXC__Location__c\",\"operator\":\"eq\",\"operand\":\"SVMX.USERTRUNK\",\"fieldRelationshipName\":\"SVMXC__Location__r\",\"isNameField\":false,\"parameterType\":\"Constant\",\"sortOrder\":\"Ascending\",\"recordTypeId\":\"0121I000000ZGZ9QAO\"}]}]}},{\"id\":\"a0e1I000005lYeQQAU\",\"controlType\":\"Standard\",\"dataType\":\"currency\",\"detailType\":\"Field\",\"displayColumn\":4.0,\"displayRow\":0.0,\"fieldApiName\":\"SVMXC__Total_Line_Price__c\",\"overrideRelatedLookup\":false,\"readOnly\":true,\"required\":false,\"showIniPad\":false,\"showInWeb\":false,\"isStandard\":false,\"sequence\":4.0,\"pageLayout\":\"a0f1I000001fsvCQAQ\",\"noOfColumns\":0}]}]},\"rulesAndFormulas\":[{\"id\":\"a1o1I0000011zxvQAA\",\"sfmProcessId\":\"a1o1I0000011zxFQAQ\",\"processNodeObjectId\":\"a1o1I0000011zxtQAA\",\"ruleFormulaId\":\"a1o1I0000011zx5QAA\",\"sequence\":\"0.0\",\"recordTypeId\":\"0121I000000ZGZiQAO\",\"dataValidationRule\":{\"id\":\"a1o1I0000011zx5QAA\",\"processId\":\"Rollup_Summary\",\"name\":\"Rollup Summary\",\"description\":\"Updating the Rollup summary field\",\"sourceObjectName\":\"SVMXC__Service_Order__c\",\"ruleType\":\"Field Update Rule\"},\"formula\":{\"id\":\"a1o1I0000011zx5QAA\",\"processId\":\"Rollup_Summary\",\"name\":\"Rollup Summary\",\"description\":\"Updating the Rollup summary field\",\"sourceObjectName\":\"SVMXC__Service_Order__c\",\"ruleType\":\"Field Update Rule\",\"targetObjectLabel\":\"Work Order\",\"formulaFieldUpdates\":[{\"id\":\"a1m1I00000081CGQAY\",\"expressionRule\":\"a1o1I0000011zx5QAA\",\"expressionType\":\"Field_Update_Rule\",\"sequence\":0.0,\"fieldName\":\"SVMXC__Proforma_Invoice_Amount__c\",\"formula\":\"$F.SUMOF($D.Parts,'SVMXC__Actual_Quantity2__c')\",\"description\":\"[{\\\"objectLabel\\\":\\\"Work Order\\\",\\\"sequence\\\":0,\\\"aliasName\\\":\\\"Work_Order\\\"},{\\\"objectLabel\\\":\\\"Work Detail (Work Order)\\\",\\\"sequence\\\":1,\\\"aliasName\\\":\\\"Work_Detail__Work_Order_\\\"}]\",\"actionType\":\"Set Value\"}]}},{\"id\":\"a1o1I0000011zxwQAA\",\"sfmProcessId\":\"a1o1I0000011zxFQAQ\",\"processNodeObjectId\":\"a1o1I0000011zxuQAA\",\"ruleFormulaId\":\"a1o1I0000011zxAQAQ\",\"sequence\":\"1.0\",\"recordTypeId\":\"0121I000000ZGZiQAO\",\"dataValidationRule\":{\"id\":\"a1o1I0000011zxAQAQ\",\"processId\":\"DifferenceBetTime\",\"name\":\"DifferenceBetTime\",\"description\":\"Difference between Start date time and date time in days  and update the same in Line qty\",\"sourceObjectName\":\"SVMXC__Service_Order_Line__c\",\"ruleType\":\"Field Update Rule\"},\"formula\":{\"id\":\"a1o1I0000011zxAQAQ\",\"processId\":\"DifferenceBetTime\",\"name\":\"DifferenceBetTime\",\"description\":\"Difference between Start date time and date time in days  and update the same in Line qty\",\"sourceObjectName\":\"SVMXC__Service_Order_Line__c\",\"ruleType\":\"Field Update Rule\",\"targetObjectLabel\":\"Work Detail (Work Order)\",\"formulaFieldUpdates\":[{\"id\":\"a1m1I00000081CLQAY\",\"expressionRule\":\"a1o1I0000011zxAQAQ\",\"expressionType\":\"Field_Update_Rule\",\"sequence\":0.0,\"fieldName\":\"SVMXC__Actual_Quantity2__c\",\"formula\":\"$F.MULTIPLY($F.DATEDIFF($D.Work_Detail__Work_Order_.SVMXC__Start_Date_and_Time__c,$D.Work_Detail__Work_Order_.SVMXC__End_Date_and_Time__c,'INDAYS'),24)\",\"description\":\"[{\\\"objectLabel\\\":\\\"Work Order\\\",\\\"sequence\\\":0,\\\"aliasName\\\":\\\"Work_Order\\\"},{\\\"objectLabel\\\":\\\"Work Detail (Work Order)\\\",\\\"sequence\\\":1,\\\"aliasName\\\":\\\"Work_Detail__Work_Order_\\\"}]\",\"actionType\":\"Set Value\"}]}}]}";
        String p = "\"rulesAndFormulas\":[{\"id\":\"a1o1I0000011zxvQAA\",\"sfmProcessId\":\"a1o1I0000011zxFQAQ\",\"processNodeObjectId\":\"a1o1I0000011zxtQAA\",\"ruleFormulaId\":\"a1o1I0000011zx5QAA\",\"sequence\":\"0.0\",\"recordTypeId\":\"0121I000000ZGZiQAO\",\"dataValidationRule\":{\"id\":\"a1o1I0000011zx5QAA\",\"processId\":\"Rollup_Summary\",\"name\":\"Rollup Summary\",\"description\":\"Updating the Rollup summary field\",\"sourceObjectName\":\"SVMXC__Service_Order__c\",\"ruleType\":\"Field Update Rule\"},\"formula\":{\"id\":\"a1o1I0000011zx5QAA\",\"processId\":\"Rollup_Summary\",\"name\":\"Rollup Summary\",\"description\":\"Updating the Rollup summary field\",\"sourceObjectName\":\"SVMXC__Service_Order__c\",\"ruleType\":\"Field Update Rule\",\"targetObjectLabel\":\"Work Order\",\"formulaFieldUpdates\":[{\"id\":\"a1m1I00000081CGQAY\",\"expressionRule\":\"a1o1I0000011zx5QAA\",\"expressionType\":\"Field_Update_Rule\",\"sequence\":0.0,\"fieldName\":\"SVMXC__Proforma_Invoice_Amount__c\",\"formula\":\"$F.SUMOF($D.Parts,'SVMXC__Actual_Quantity2__c')\",\"description\":\"[{\\\"objectLabel\\\":\\\"Work Order\\\",\\\"sequence\\\":0,\\\"aliasName\\\":\\\"Work_Order\\\"},{\\\"objectLabel\":\\\"Work Detail (Work Order)\\\",\\\"sequence\\\":1,\\\"aliasName\\\":\\\"Work_Detail__Work_Order_\\\"}]\",\"actionType\":\"Set Value\"}]}},{\"id\":\"a1o1I0000011zxwQAA\",\"sfmProcessId\":\"a1o1I0000011zxFQAQ\",\"processNodeObjectId\":\"a1o1I0000011zxuQAA\",\"ruleFormulaId\":\"a1o1I0000011zxAQAQ\",\"sequence\":\"1.0\",\"recordTypeId\":\"0121I000000ZGZiQAO\",\"dataValidationRule\":{\"id\":\"a1o1I0000011zxAQAQ\",\"processId\":\"DifferenceBetTime\",\"name\":\"DifferenceBetTime\",\"description\":\"Difference between Start date time and date time in days  and update the same in Line qty\",\"sourceObjectName\":\"SVMXC__Service_Order_Line__c\",\"ruleType\":\"Field Update Rule\"},\"formula\":{\"id\":\"a1o1I0000011zxAQAQ\",\"processId\":\"DifferenceBetTime\",\"name\":\"DifferenceBetTime\",\"description\":\"Difference between Start date time and date time in days  and update the same in Line qty\",\"sourceObjectName\":\"SVMXC__Service_Order_Line__c\",\"ruleType\":\"Field Update Rule\",\"targetObjectLabel\":\"Work Detail (Work Order)\",\"formulaFieldUpdates\":[{\"id\":\"a1m1I00000081CLQAY\",\"expressionRule\":\"a1o1I0000011zxAQAQ\",\"expressionType\":\"Field_Update_Rule\",\"sequence\":0.0,\"fieldName\":\"SVMXC__Actual_Quantity2__c\",\"formula\":\"$F.MULTIPLY($F.DATEDIFF($D.Work_Detail__Work_Order_.SVMXC__Start_Date_and_Time__c,$D.Work_Detail__Work_Order_.SVMXC__End_Date_and_Time__c,'INDAYS'),24)\",\"description\":\"[{\\\"objectLabel\\\":\\\"Work Order\\\",\\\"sequence\\\":0,\\\"aliasName\\\":\\\"Work_Order\\\"},{\\\"objectLabel\\\":\\\"Work Detail (Work Order)\\\",\\\"sequence\\\":1,\\\"aliasName\\\":\\\"Work_Detail__Work_Order_\\\"}]\",\"actionType\":\"Set Value\"}]}}]}";
        System.out.println(s.contains(p));
    }
}
