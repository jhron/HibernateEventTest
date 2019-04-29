package hibernateeventstest

import grails.compiler.GrailsCompileStatic

@GrailsCompileStatic
class Person {
    String name
    Map<String, Object> customFieldValueDomains = null
    Map<String, Object> customFields = new HashMap<String, Object>()

    static transients = ['customFields', 'customFieldValueDomains']
    static constraints = {
        customFields(bindable: true)
    }

    public Map<String, Object> getCustomFields() {
        getCustomFieldValueDomains()
        return this.customFields
    }
    public Map<String, Object> getCustomFieldValueDomains() {
        if (null == this.customFieldValueDomains) {
            this.customFieldValueDomains = new HashMap<String, Object>()
            CustomFieldsManager.loadFields(this, Person)
        }
        return this.customFieldValueDomains
    }
}
