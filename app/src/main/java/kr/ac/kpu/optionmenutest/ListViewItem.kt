package kr.ac.kpu.optionmenutest

import java.time.LocalDate

class ListViewItem {
    private var Sgcnm: String? = null //sgcnm
    private var Sitenm: String? = null //sitenm
    private lateinit var date: LocalDate //늦은 초기화 //이건 일단 보류
    private var taste: String? = null
    private var smell: String? = null
    private var color: Double? = 0.00
    private var ph: Double? = 0.00
    private var ntu: Double? = 0.00
    private var cl: Double? = 0.00

    constructor(Sgcnm: String, Sitenm: String, ph: Double){ //constructor: 코틀린 생성자
        this.Sgcnm = Sgcnm
        this.Sitenm = Sitenm
        this.ph = ph
    }

    fun setSgcnm(Sgcnm: String) { this.Sgcnm = Sgcnm }

    fun setSitenm(Sitenm: String) {this.Sitenm = Sitenm}

    fun setPh(ph: Double){this.ph = ph}

    fun getSgcnm(): String? { return this.Sgcnm }

    fun getSitenm(): String? { return this.Sitenm}

    fun getPh(): Double? { return this.ph}
}