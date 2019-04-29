package hibernateeventstest

import hibernateeventstest.Person

class BootStrap {

    def init = { servletContext ->
        def p1 = new Person( name: 'Michal' )
        p1.save(flush: true)
    }
    def destroy = {
    }
}
