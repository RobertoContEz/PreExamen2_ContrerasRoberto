package contreras.roberto.preexamen

data class Contacto (
    var color: Int,
    var nombre: String,
    var apellido: String,
    var nacimiento: String,
    var numero: String
){
    companion object {
        var lista = ArrayList<Contacto>()
    }
}