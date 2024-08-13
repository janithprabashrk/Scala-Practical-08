object CaesarCipher {

    def encrypt(text : String, shift : Int) : String = {
        text.map(chr =>
            if(chr.isLetter) {
                val base = if (chr.isUpper) 'A' else 'a'
                ((chr - base + shift) % 26 + base).toChar
            }
            else chr
        )
    } 

    def decrypt(text : String, shift : Int) : String = {
        encrypt(text, 26 - shift)
    }

    def funcSelector(text : String, shift : Int, function: (String, Int) => String) : String = {
        function(text, shift)
    }

    def main(args : Array[String]) : Unit = {
        val text = "Scala Practicals"
        val shift = 3
        val encrypted = funcSelector(text, shift, encrypt)
        val decrypted = funcSelector(encrypted, shift, decrypt)

        println("Certain text : " + text)
        println("Encrypted text : " + encrypted)
        println("Decrypted text : " + decrypted)
    }
}