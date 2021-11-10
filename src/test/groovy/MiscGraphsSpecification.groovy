import org.junit.jupiter.api.Disabled
import spock.lang.Specification

class MiscGraphsSpecification extends Specification {
    def "should be a simple assertion"() {
        expect:
        1 == 1
    }

    def "MyName"() {
        given:
        int x = values

        expect:
        Math.abs(x) > 0

        where:
        values<<[1,2,-4,5,23]
    }
}
