package hibernateeventstest.PersonController

import hibernateeventstest.Person

class GroovyController {

    def eventTest() {
        def p = Person.get(1L)
        def customFields = [
                'age'   : 4,
                'height': '',
                'weight': ''
        ]
        params.put('customFields', customFields)
        p.properties = params
        p.save()
        render "done"
    }
}
