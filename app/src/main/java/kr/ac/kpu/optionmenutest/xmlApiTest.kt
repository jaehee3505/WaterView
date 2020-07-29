package kr.ac.kpu.optionmenutest

import android.os.Build
import androidx.annotation.RequiresApi
import org.w3c.dom.Document
import org.w3c.dom.Element
import org.w3c.dom.Node
import org.w3c.dom.NodeList
import java.time.LocalDate
import javax.xml.parsers.DocumentBuilderFactory

@RequiresApi(Build.VERSION_CODES.O)
fun main(args: Array<String>) {
    val onlyDate: LocalDate = LocalDate.now()
    val key: String = "jrHefDB3zZXYxtdOH3FxxoKg4R3c2YNutlOinWRD4IGsXZJcuFPRE40oRkeT4%2FpHYAfWlTg7pSdB3N%2FTg3s8pg%3D%3D"
    var url: String = "http://opendata.kwater.or.kr/openapi-data/service/pubd/waterinfos/waterquality/daywater/list?serviceKey=" + key + "&sgccd<=99999&sitecd<=21002&stdt=2020-07-27&eddt=2020-07-28&numOfRows=9999&pageNo=1&"
    // {}
    val xml: Document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(url)

    xml.documentElement.normalize()

    println("test")

    val list: NodeList = xml.getElementsByTagName("item")

    for (i in 0..list.length - 1) {

        var n: Node = list.item(i)

        if (n.getNodeType() == Node.ELEMENT_NODE) {

            val elem = n as Element

            val map = mutableMapOf<String, String>()



            for (j in 0..elem.attributes.length - 1) {

                map.putIfAbsent(elem.attributes.item(j).nodeName, elem.attributes.item(j).nodeValue)
            }

            var num:Float? = null

            println("=========${i + 1}=========")

            println("1. 날짜: ${elem.getElementsByTagName("cltdt")?.item(0)?.textContent}")

            println("2. 색깔: ${elem.getElementsByTagName("data1")?.item(0)?.textContent}")

            println("3. 농도: ${elem.getElementsByTagName("data2")?.item(0)?.textContent}")

            println("4. 탁도: ${elem.getElementsByTagName("data3")?.item(0)?.textContent}")

            println("5. PH: ${elem.getElementsByTagName("data4")?.item(0)?.textContent}")

            println("6. : ${elem.getElementsByTagName("data5")?.item(0)?.textContent}")

            println("7. : ${elem.getElementsByTagName("sgcnm")?.item(0)?.textContent}")

            println("8. : ${elem.getElementsByTagName("sitenm")?.item(0)?.textContent}")
        }
    }
}