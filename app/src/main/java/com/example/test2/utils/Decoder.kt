package com.example.test2.utils
import android.util.Base64
import com.auth0.jwt.JWT
//import com.auth0.android.jwt.JWT
import com.auth0.jwt.interfaces.DecodedJWT

class Decoder {
    companion object{

        fun decode(strEncoded: String): DecodedJWT {
            return JWT.decode(strEncoded);
        }

        // Try 2, da excepción de llave incorrecta, se debe habilitar la linea 5 y comentar la 4
        /*fun decodeTry2(strEncoded: String) : String?{
            try {//HS256
                val algorithm = Algorithm.HMAC256("ejemplo1");
                val verifier: JWTVerifier = JWT.require(algorithm)
                    .withIssuer("auth0")
                    .build() //Reusable verifier instance

                val jwt: DecodedJWT = verifier.verify(strEncoded)
                if (jwt != null){

                }

            }catch (e:Exception){
                if (e != null){

                }
            }
            return "";
        }*/

        fun getGson(strEncoded:String) : String{
            val decodedBytes = Base64.decode(strEncoded, Base64.URL_SAFE);
            return decodedBytes.toString();
        }
    }
}