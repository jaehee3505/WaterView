package kr.ac.kpu.optionmenutest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ListView
import kotlinx.android.synthetic.main.activity_api_test_field.*

class ApiTestField : AppCompatActivity() {

    private lateinit var editText: EditText
    private lateinit var listView: ListView
    var adapter: ListViewAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_api_test_field)

        listView = findViewById(R.id.listView)
        editText = findViewById(R.id.editText)

        Btn1.setOnClickListener() {
            /*val thread = Thread({
                var apiPublicWater = ApiPublicWater(editText.text.toString())
                adapter = apiPublicWater.main()
                runOnUiThread {
                    listView.adapter = adapter
                }
            }).start()*/
            Btn1.setText("I'm alive")
        }
    }
/*
    fun onClickButton(view: View){
        val thread = Thread({
            var apiPublicWater = ApiPublicWater(editText.text.toString())
            adapter = apiPublicWater.main()
            runOnUiThread{
                listView.adapter = adapter
            }
        }).start()
    }
 */
}




