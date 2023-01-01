package com.kadironcul.harry_potter_card_game

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.activity_giris.*

class Giris : AppCompatActivity() {
    var kullanici_adi:String=""
    var sifre:String=""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_giris)
    }
    fun Giris_Giris_Yap_Button(view : View) {


        var database= FirebaseDatabase.getInstance().getReference("Kullanicilar")
        kullanici_adi=editText_Kullanici_Adi.text.toString()
        sifre=editText_Şifre.text.toString()
        var kontrol=0
        // Giris Yapilan Kullanici Adi Ve Sifrenin Kontrolu
        if(kullanici_adi.isNotEmpty() && sifre.isNotEmpty()){
            var getdata=object :ValueEventListener{
                override fun onDataChange(snapshot: DataSnapshot) {
                    for(k in snapshot.children)
                    {
                        var VT_Okunan_Kullanici_Adi=k.child("kullanici_Adi").getValue()
                        var VT_Okunan_Sifre=k.child("sifre").getValue()
                        if(VT_Okunan_Kullanici_Adi.toString()==kullanici_adi && VT_Okunan_Sifre.toString()==sifre)
                        {
                            Toast.makeText(applicationContext,"Giriş Başarılı", Toast.LENGTH_SHORT).show()
                            kontrol=1
                            val intent1= Intent(applicationContext,Giris_Yap_Menu::class.java)
                            intent1.putExtra("Yollanan_Veri_Kullanici_Adi",kullanici_adi)
                            intent1.putExtra("Yollanan_Veri_Sifre",sifre)
                            startActivity(intent1)
                            finish()
                            break
                        }
                    }
                    if(kontrol==0)
                    {
                        Toast.makeText(applicationContext,"Kullanıcı Adı yada Sifre Yanlış Giriş Başarısız!!!", Toast.LENGTH_SHORT).show()
                    }
                }
                override fun onCancelled(error: DatabaseError) {
                    TODO("Not yet implemented")
                }
            }
            database.addValueEventListener(getdata)
            //database.addListenerForSingleValueEvent(getdata)
        }
    }
    fun kayit_Ol_Geri_Image(view : View) {
        val intent2= Intent(applicationContext,MainActivity::class.java)
        startActivity(intent2)
        finish()
    }
}