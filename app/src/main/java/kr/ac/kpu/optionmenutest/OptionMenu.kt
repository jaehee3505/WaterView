package kr.ac.kpu.optionmenutest

import android.os.Bundle
import android.view.Menu
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_option_menu.*


class OptionMenu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_option_menu)


        if (intent.hasExtra("WaterData")) {

            /*
            val bundle = intent.getBundleExtra("bundle") !!
            siText.text = bundle!!.getSerializable("Si") as? String
            dongText.text = bundle!!.getSerializable("Dong") as? String
            */
             
            var data = intent.getParcelableExtra<data>("WaterData")
            if (data != null) {
                siText.text = data.Si
                dongText.text = data.Dong
            }
            else{
                Toast.makeText(this, "전달된 내용이 없습니다", Toast.LENGTH_SHORT).show()
            }
        }
        else{
            Toast.makeText(this, "전달된 이름이 없습니다", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)
        val mInflater = getMenuInflater()
        mInflater.inflate(R.menu.menu, menu)
        return true
    }
}