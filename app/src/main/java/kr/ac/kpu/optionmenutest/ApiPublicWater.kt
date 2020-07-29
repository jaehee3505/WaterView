package kr.ac.kpu.optionmenutest
import org.json.JSONException
import org.json.JSONObject
import java.io.*
import java.lang.RuntimeException
import java.net.MalformedURLException
import java.net.URL
import java.net.URLEncoder



class ApiPublicWater(sgcnm:String) {
    var sgcnm: String

    init {
        this.sgcnm = sgcnm
    }

    var adapter : ListViewAdapter = ListViewAdapter()

    val key: String = "jrHefDB3zZXYxtdOH3FxxoKg4R3c2YNutlOinWRD4IGsXZJcuFPRE40oRkeT4%2FpHYAfWlTg7pSdB3N%2FTg3s8pg%3D%3D"
    var waterURL: String = "http://opendata.kwater.or.kr/openapi-data/service/pubd/waterinfos/waterquality/daywater/list?serviceKey=" + key + "&sgccd<=99999&sitecd<=21002&stdt=2020-07-27&eddt=2020-07-28&numOfRows=9999&pageNo=1&json"

    fun main(): ListViewAdapter{
        var text: String? = null
        try{
            text = URLEncoder.encode(sgcnm,"UTF-8")
        }catch(e:UnsupportedEncodingException){
            throw RuntimeException("검색어 인코딩 실패")
        }

        val url = "$waterURL?address=$text"
        val responseBody = get(url)
        parseData(responseBody)

        return adapter
    }

    private operator fun get(apiUrl:String):String{
        var responseBody: String = ""
        try{
            var url = URL(apiUrl)
            val `in` = url.openStream()
            responseBody = readBody(`in`)
        }catch (e:MalformedURLException){
            e.printStackTrace()
        }catch (e:IOException){
            e.printStackTrace()
        }

        return responseBody
    }

    private fun readBody(body: InputStream): String {
        val streamReader = InputStreamReader(body)

        try {
            BufferedReader(streamReader).use({ lineReader ->
                val responseBody = StringBuilder()

                var line: String? = lineReader.readLine()
                while( line != null ){
                    responseBody.append(line)
                    line = lineReader.readLine()
                }
                return responseBody.toString()
            })
        }catch (e:IOException){
            throw RuntimeException("API 응답을 읽는데 실패했습니다.",e)
        }
    }

    private fun parseData(responseBody: String){
        var Sgcnm: String
        var Sitenm: String
        var ph: Double
        var jsonObject = JSONObject(responseBody)
        try {
            val jsonArray = jsonObject.getJSONArray("waterURL")

            for (index in 0 until jsonArray.length()){
                val item = jsonArray.getJSONObject(index).apply {
                    Sgcnm = getString("sgcnm")
                    Sitenm = getString("sitenm")
                    ph = getDouble("data4")

                    println("Sgcnm: $Sgcnm")
                    println("Sitenm: $Sitenm")
                    println("ph: $ph")

                    adapter.addItem(Sgcnm,Sitenm,ph)
                }
            }

        }catch (e: JSONException){
            e.printStackTrace()
        }
    }
}


