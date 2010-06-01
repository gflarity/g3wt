package g3wt

class DataService {

    static transactional = true

    static expose = [ 'gwt:g3wt.client' ]

    String helloWorld() {
        return "Hello, World!"
    }

}
