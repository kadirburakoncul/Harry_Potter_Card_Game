package com.kadironcul.harry_potter_card_game

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_giris_yap_menu.*

class Giris_Yap_Menu : AppCompatActivity() {
    var Oyuncu_Sayisi=0
    var Alinan_Veri_Kullanici_Adi:String=""
    var Alinan_Veri_Sifre:String=""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_giris_yap_menu)
        val intent = intent
        Alinan_Veri_Kullanici_Adi = intent.getStringExtra("Yollanan_Veri_Kullanici_Adi").toString()
        Alinan_Veri_Sifre = intent.getStringExtra("Yollanan_Veri_Sifre").toString()
        giris_Yap_Menu_Tek_Oyuncu_Button.visibility=View.INVISIBLE
        giris_Yap_Menu_Coklu_Oyuncu_Button.visibility=View.INVISIBLE
        giris_Yap_Menu_Oyun_Modu_2lik_Button.visibility=View.INVISIBLE
        giris_Yap_Menu_Oyun_Modu_4luk_Button.visibility=View.INVISIBLE
        giris_Yap_Menu_Oyun_Modu_6lik_Button.visibility=View.INVISIBLE
    }

    fun Giris_Yap_Menu_Oyuna_Basla_Button(view: View){
        giris_Yap_Menu_Oyuna_Basla_Button.visibility= View.INVISIBLE
        giris_Yap_Menu_Tek_Oyuncu_Button.visibility= View.VISIBLE
        giris_Yap_Menu_Coklu_Oyuncu_Button.visibility= View.VISIBLE
    }
    fun Giris_Yap_Menu_Tek_Oyuncu_Button(view: View)
    {
        Oyuncu_Sayisi=1
        giris_Yap_Menu_Tek_Oyuncu_Button.visibility= View.INVISIBLE
        giris_Yap_Menu_Coklu_Oyuncu_Button.visibility= View.INVISIBLE
        giris_Yap_Menu_Oyun_Modu_2lik_Button.visibility= View.VISIBLE
        giris_Yap_Menu_Oyun_Modu_4luk_Button.visibility= View.VISIBLE
        giris_Yap_Menu_Oyun_Modu_6lik_Button.visibility= View.VISIBLE
    }
    fun Giris_Yap_Menu_Coklu_Oyuncu_Button(view: View)
    {
        Oyuncu_Sayisi=2
        giris_Yap_Menu_Tek_Oyuncu_Button.visibility= View.INVISIBLE
        giris_Yap_Menu_Coklu_Oyuncu_Button.visibility= View.INVISIBLE
        giris_Yap_Menu_Oyun_Modu_2lik_Button.visibility= View.VISIBLE
        giris_Yap_Menu_Oyun_Modu_4luk_Button.visibility= View.VISIBLE
        giris_Yap_Menu_Oyun_Modu_6lik_Button.visibility= View.VISIBLE
    }
    fun Giris_Yap_Menu_Oyun_Modu_2lik_Button(view: View)
    {
        val intent1= Intent(applicationContext,Oyun_2lik::class.java)
        intent1.putExtra("Yollanan_Veri_Oyuncu_Sayisi",Oyuncu_Sayisi)
        intent1.putExtra("Yollanan_Veri_Kullanici_Adi",Alinan_Veri_Kullanici_Adi)
        intent1.putExtra("Yollanan_Veri_Sifre",Alinan_Veri_Sifre)
        startActivity(intent1)
        finish()
    }
    fun Giris_Yap_Menu_Oyun_Modu_4luk_Button(view: View)
    {
        val intent1= Intent(applicationContext,Oyun_4luk::class.java)
        intent1.putExtra("Yollanan_Veri_Oyuncu_Sayisi",Oyuncu_Sayisi)
        intent1.putExtra("Yollanan_Veri_Kullanici_Adi",Alinan_Veri_Kullanici_Adi)
        intent1.putExtra("Yollanan_Veri_Sifre",Alinan_Veri_Sifre)
        startActivity(intent1)
        finish()
    }
    fun Giris_Yap_Menu_Oyun_Modu_6lik_Button(view: View)
    {
        val intent1= Intent(applicationContext,Oyun_6lik::class.java)
        intent1.putExtra("Yollanan_Veri_Oyuncu_Sayisi",Oyuncu_Sayisi)
        intent1.putExtra("Yollanan_Veri_Kullanici_Adi",Alinan_Veri_Kullanici_Adi)
        intent1.putExtra("Yollanan_Veri_Sifre",Alinan_Veri_Sifre)
        startActivity(intent1)
        finish()
    }
    fun Giris_Yap_Menu_Geri_Image(view: View){
        val intent2= Intent(applicationContext,MainActivity::class.java)
        startActivity(intent2)
        finish()
    }
    fun Giris_Yap_Menu_Ayarlar_Image(view: View)
    {
        val intent2= Intent(applicationContext,Bilgi_Guncelleme::class.java)
        intent2.putExtra("Yollanan_Veri_Kullanici_Adi",Alinan_Veri_Kullanici_Adi)
        intent2.putExtra("Yollanan_Veri_Sifre",Alinan_Veri_Sifre)
        startActivity(intent2)
        finish()
    }
}