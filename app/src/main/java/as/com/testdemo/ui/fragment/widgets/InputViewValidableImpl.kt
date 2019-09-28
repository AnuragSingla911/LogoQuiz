package `as`.com.testdemo.ui.fragment.widgets


class InputViewValidableImpl : Validable {

    var value : String?
    var map : HashMap<Char?, SquareView>
    var count : Int = 0
    constructor(value : String?, map : HashMap<Char?, SquareView> ){
        this.value = value
        this.map = map
    }

    override fun incrementCount(keyCode: Char){
            if(map.containsKey(keyCode)){
                if(map.get(keyCode)?.isShown?.not() == true) {
                    map.get(keyCode)?.isShown = true
                    count++;
                }
            }
    }
    override fun isValidated(): Boolean {

        return value?.length == count
    }

}