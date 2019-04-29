package hibernateeventstest

class PersonCustomFields {
    Long intValue
    Double floatValue
    String stringValue

    static belongsTo = [ owner: Person ]

    static constraints = {
        intValue(nullable: true)
        floatValue(nullable: true)
        stringValue(nullable: true)
    }
}
