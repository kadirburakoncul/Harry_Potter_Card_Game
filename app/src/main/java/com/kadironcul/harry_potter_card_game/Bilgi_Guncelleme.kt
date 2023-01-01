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
import kotlinx.android.synthetic.main.activity_bilgi_guncelleme.*

class Bilgi_Guncelleme : AppCompatActivity() {
    var Alinan_Veri_Kullanici_Adi=""
    var Alinan_Veri_Sifre=""
    var sayi=0
    var Degistirilecek_ID=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bilgi_guncelleme)
        val intent = intent
        Alinan_Veri_Kullanici_Adi = intent.getStringExtra("Yollanan_Veri_Kullanici_Adi").toString()
        Alinan_Veri_Sifre = intent.getStringExtra("Yollanan_Veri_Sifre").toString()
        bilgi_Guncelleme_Kullanici_Adi_Text.text=Alinan_Veri_Kullanici_Adi
        var database= FirebaseDatabase.getInstance().getReference("Kullanicilar")
        var getdata=object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                for(k in snapshot.children)
                {
                    sayi=sayi+1
                    var VT_Okunan_Kullanici_Adi=k.child("kullanici_Adi").getValue()
                    var VT_Okunan_Sifre=k.child("sifre").getValue()
                    if(VT_Okunan_Kullanici_Adi.toString()==Alinan_Veri_Kullanici_Adi && VT_Okunan_Sifre.toString()==Alinan_Veri_Sifre)
                    {
                        Degistirilecek_ID=sayi
                        break
                    }
                }
            }
            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        }
        database.addValueEventListener(getdata)
    }
    fun Bilgi_Guncelleme_Geri_Image(view: View)
    {
        val intent2= Intent(applicationContext,Giris_Yap_Menu::class.java)
        intent2.putExtra("Yollanan_Veri_Kullanici_Adi",Alinan_Veri_Kullanici_Adi)
        intent2.putExtra("Yollanan_Veri_Sifre",Alinan_Veri_Sifre)
        startActivity(intent2)
        finish()
    }
    fun Bilgi_Guncelleme_Guncelle(view: View)
    {
        var yeni_sifre=bilgi_Guncelleme_Sifre_Text.text.toString()
        update_data(Alinan_Veri_Kullanici_Adi,yeni_sifre)
        bilgi_Guncelleme_Sifre_Text.text.clear()
    }
    fun update_data(kullanici_adi:String,sifre:String)
    {

        var database= FirebaseDatabase.getInstance().getReference("Kullanicilar")
        val kisi= mapOf<String,String>(
            "kullanici_Adi" to kullanici_adi,
            "sifre" to sifre
        )
        database.child("$Degistirilecek_ID").updateChildren(kisi).addOnSuccessListener {
            bilgi_Guncelleme_Sifre_Text.text.clear()
            Toast.makeText(this,"Şifre Değiştirildi", Toast.LENGTH_SHORT).show()
            Alinan_Veri_Sifre=sifre
        }.addOnFailureListener{
            Toast.makeText(this,"Şifre Değiştirilemedi", Toast.LENGTH_SHORT).show()
        }
    }
}