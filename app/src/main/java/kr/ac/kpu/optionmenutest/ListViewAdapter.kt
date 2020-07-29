package kr.ac.kpu.optionmenutest

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import java.lang.reflect.Array

//=============================================보류=============================================


class ListViewAdapter : BaseAdapter() { //BaseAdapter() 상속
    var list = ArrayList<ListViewItem>() //<클래스>

    override fun getCount(): Int {
        return list.size
    } //list 크기

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    

    override fun getItem(position: Int): Any {
        return list.get(position)
    }

    fun getSize(): Int {
        return list.size
    } //??? getCount와 기능 동일

    fun addItem(Sgcnm: String, Sitenm: String, ph: Double) {
        var item = ListViewItem(Sgcnm, Sitenm, ph)
        list.add(item)
        println("in ListViewAdapter --> listSize : " + list.size)
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {
        var context = parent?.getContext()
        var convertV = convertView

        if (convertView == null) {
            val systemService =
                context?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        }
        //==========================================================================================
        var ph = convertV?.findViewById(R.id.PHText2) as TextView

        val listViewItem = list[position]

        ph.text = listViewItem.getPh().toString()

        return convertV
    }
}