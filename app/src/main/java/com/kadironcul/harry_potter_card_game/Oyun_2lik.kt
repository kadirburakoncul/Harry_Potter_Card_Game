package com.kadironcul.harry_potter_card_game

import android.content.DialogInterface
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Base64
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.activity_oyun2lik.*

class Oyun_2lik : AppCompatActivity() {
    var Alinan_Veri_Oyuncu_Sayisi=0
    var Alinan_Veri_Kullanici_Adi:String=""
    var Alinan_Veri_Sifre:String=""
    var DB_Isimler=ArrayList<String>()
    var DB_Evler=ArrayList<String>()
    var DB_Puanlar=ArrayList<Int>()
    var Resim_Dizisi=ArrayList<Bitmap>()
    var st:String=""
    var imageArray=ArrayList<ImageView>()
    var imageArray_Kapali=ArrayList<ImageView>()
    var Dolu_Imageler=IntArray(4)
    var Kullanilan_Resimler=IntArray(44)
    var Imagelere_Atanan_Isimler=ArrayList<String>()
    var Imagelere_Atanan_Evler=ArrayList<String>()
    var Imagelere_Atanan_Ev_Katsayi=IntArray(4)
    var Imagelere_Atanan_Puanlar=IntArray(4)
    var Imagelere_Atanan_Resimler=IntArray(4)
    var Birinci_Oyuncu_Puani=0.0f
    var Ikinci_Oyuncu_Puani=0.0f
    var imageArray_Sayi_Dizisi=IntArray(4)
    var imageArray_Kapali_Sayi_Dizisi=IntArray(4)
    var kalan_sure:Float=0.0f
    var sure1=45.0f
    var sure2=60.0f
    var acilan_kart_kontrolu=ArrayList<Int>()
    var Oyun_Sira_Hakki=1
    var mediaplayer_oyun_boyunca_calan_muzik:MediaPlayer?=null
    var mediaplayer_oyun_dogru_eslesmede_muzik:MediaPlayer?=null
    var mediaplayer_oyun_sure_bitmeden_eslesme_bittiginde_calan_muzik:MediaPlayer?=null
    var mediaplayer_oyun_sure_bittiginde_calan_muzik:MediaPlayer?=null
    var atama_degeri=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_oyun2lik)
        ///////////////////////////////////////////////////////////////
        Baslat_Butonu_2lik.visibility=View.INVISIBLE
        ///////////////////////////////////////////////////////////////
        imageArray.add(image1_2lik);
        imageArray.add(image2_2lik);
        imageArray.add(image3_2lik);
        imageArray.add(image4_2lik);
        imageArray_Kapali.add(image1_2lik_kapali)
        imageArray_Kapali.add(image2_2lik_kapali)
        imageArray_Kapali.add(image3_2lik_kapali)
        imageArray_Kapali.add(image4_2lik_kapali)
        ///////////////////////////////////////////////////////////////
        for(image in imageArray){
            image.visibility= View.INVISIBLE
        }
        for(image in imageArray_Kapali){
            image.visibility= View.INVISIBLE
        }
        ///////////////////////////////////////////////////////////////
        kalan_sure_text_2lik.visibility=View.INVISIBLE
        Oyun_2lik_Ipucu_Text.visibility=View.INVISIBLE
        birinci_oyuncu_skor_text_2lik.visibility=View.INVISIBLE
        ikinci_oyuncu_skor_text_2lik.visibility=View.INVISIBLE
        Oyun_2lik_kapat_Image.visibility=View.INVISIBLE
        Oyun_2lik_Ipucu_Image.visibility=View.VISIBLE
        ///////////////////////////////////////////////////////////////
        Resimleri_Databaseden_Cek_2lik()

    }
    fun Resimleri_Databaseden_Cek_2lik()
    {
        var database= FirebaseDatabase.getInstance().getReference("Resimler")
        var getdata=object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                for (k in snapshot.children) {
                    var DB_Okunan_Resim_Isim=k.child("resim_Adi").getValue()
                    var DB_Okunan_Resim_Ev=k.child("resim_Evi").getValue()
                    var DB_Okunan_Resim_Puani=k.child("resim_Puani").getValue()
                    var DB_Okunan_Resim_Base64=k.child("resim_Base64").getValue()
                    st=(DB_Okunan_Resim_Base64.toString())
                    var resimByte = Base64.decode(st, 0)
                    var resim = BitmapFactory.decodeByteArray(resimByte, 0, resimByte.size)

                    Resim_Dizisi.add(resim)
                    DB_Isimler.add(DB_Okunan_Resim_Isim.toString())
                    DB_Evler.add(DB_Okunan_Resim_Ev.toString())
                    DB_Puanlar.add(DB_Okunan_Resim_Puani.toString().toInt())
                    if(Resim_Dizisi.count()==44)
                    {
                        Diger_Baslangic_Islemleri_2lik()
                    }
                }
            }
            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        }
        database.addValueEventListener(getdata)
    }
    fun Diger_Baslangic_Islemleri_2lik()
    {
        for(k in (0..3))
        {
            Dolu_Imageler[k]=0
            imageArray_Sayi_Dizisi[k]=0
            imageArray_Kapali_Sayi_Dizisi[k]=0
            Imagelere_Atanan_Isimler.add(" ")
            Imagelere_Atanan_Evler.add(" ")
        }
        for(k in (0..43))
        {
            Kullanilan_Resimler[k]=0
        }
        val intent = intent
        Alinan_Veri_Oyuncu_Sayisi = intent.getIntExtra("Yollanan_Veri_Oyuncu_Sayisi",-1)
        Alinan_Veri_Kullanici_Adi = intent.getStringExtra("Yollanan_Veri_Kullanici_Adi").toString()
        Alinan_Veri_Sifre = intent.getStringExtra("Yollanan_Veri_Sifre").toString()
        ///////////////////////////////////////////////////////////////
        Toast.makeText(applicationContext,"Oyun Yüklendi", Toast.LENGTH_SHORT).show()
        Baslat_Butonu_2lik.visibility=View.VISIBLE
    }
    fun Baslat_2lik(view:View)
    {
        mediaplayer_oyun_boyunca_calan_muzik = MediaPlayer.create(this, R.raw.oyun_boyunca_calan_muzik)
        mediaplayer_oyun_dogru_eslesmede_muzik = MediaPlayer.create(this, R.raw.oyun_dogru_eslesmede_calan_muzik)
        mediaplayer_oyun_sure_bitmeden_eslesme_bittiginde_calan_muzik = MediaPlayer.create(this, R.raw.oyun_sure_bitmeden_eslesme_bittiginde_calan_muzik)
        mediaplayer_oyun_sure_bittiginde_calan_muzik = MediaPlayer.create(this, R.raw.oyun_suresi_bittiginde_calan_muzik)
        mediaplayer_oyun_boyunca_calan_muzik?.start()
        var katsayi=0
        var rastgele_resim=0

        for(a in (0..1))
        {
            while (true)
            {
                rastgele_resim = (0..43).random()
                if(Kullanilan_Resimler[rastgele_resim]==0)
                {
                    Kullanilan_Resimler[rastgele_resim]=1
                    if(DB_Evler[rastgele_resim+1]=="GRYFFİNDOR" || DB_Evler[rastgele_resim+1]=="SLYTHERİN")
                    {
                        katsayi=2
                    }
                    else
                    {
                        katsayi=1
                    }
                    break
                }
            }
            for(k in(0..1))
            {
                while(true)
                {
                    var atanacak_image_degeri=(0..3).random()
                    if(Dolu_Imageler[atanacak_image_degeri]==0)
                    {
                        Imagelere_Atanan_Isimler[atanacak_image_degeri]=(DB_Isimler[rastgele_resim+1])
                        Imagelere_Atanan_Evler[atanacak_image_degeri]=(DB_Evler[rastgele_resim+1])
                        Imagelere_Atanan_Puanlar[atanacak_image_degeri]=(DB_Puanlar[rastgele_resim+1])
                        Imagelere_Atanan_Ev_Katsayi[atanacak_image_degeri]=katsayi
                        Imagelere_Atanan_Resimler[atanacak_image_degeri]=Imagelere_Atanan_Isimler.count()
                        imageArray[atanacak_image_degeri].setImageBitmap(Resim_Dizisi[rastgele_resim])
                        Dolu_Imageler[atanacak_image_degeri]=1
                        atama_degeri=atanacak_image_degeri.toInt()+1
                        Oyun_2lik_Ipucu_Text.text=Oyun_2lik_Ipucu_Text.text.toString()+"\n"+atama_degeri.toString() + ".Resim=İsim:"+Imagelere_Atanan_Isimler[atanacak_image_degeri]+
                                ",Puan:"+Imagelere_Atanan_Puanlar[atanacak_image_degeri]+
                                ",Ev:"+Imagelere_Atanan_Evler[atanacak_image_degeri]+
                                ",Ev Katsayı:"+Imagelere_Atanan_Ev_Katsayi[atanacak_image_degeri]
                        break
                    }
                }
            }
        }
        ///////////////////////////////////////////////////////////////
        for(image in imageArray_Kapali){
            image.visibility= View.VISIBLE
        }
        kalan_sure_text_2lik.visibility=View.VISIBLE
        birinci_oyuncu_skor_text_2lik.visibility=View.VISIBLE
        Baslat_Butonu_2lik.visibility=View.INVISIBLE
        if(Alinan_Veri_Oyuncu_Sayisi==1)
        {
            kalan_sure_text_2lik.text="KALAN SÜRE : 45"
            object : CountDownTimer(45000,1000)
            {
                override fun onTick(p0: Long) {
                    kalan_sure_text_2lik.text="KALAN SÜRE : "+p0/1000
                    kalan_sure= (p0/1000).toFloat()
                }
                override fun onFinish() {
                    kalan_sure_text_2lik.text="KALAN SÜRE : 0"
                    Mesaj_2lik()
                    mediaplayer_oyun_boyunca_calan_muzik?.stop()
                    mediaplayer_oyun_dogru_eslesmede_muzik?.stop()
                    mediaplayer_oyun_sure_bittiginde_calan_muzik?.start()
                }

            }.start()
        }
        else if(Alinan_Veri_Oyuncu_Sayisi==2)
        {
            ikinci_oyuncu_skor_text_2lik.visibility=View.VISIBLE
            kalan_sure_text_2lik.text="KALAN SÜRE : 60"
            object : CountDownTimer(60000,1000)
            {
                override fun onTick(p0: Long) {
                    kalan_sure_text_2lik.text="KALAN SÜRE : "+p0/1000
                    kalan_sure= (p0/1000).toFloat()
                }

                override fun onFinish() {
                    kalan_sure_text_2lik.text="KALAN SÜRE : 0"
                    Mesaj_2lik()
                    mediaplayer_oyun_boyunca_calan_muzik?.stop()
                    mediaplayer_oyun_dogru_eslesmede_muzik?.stop()
                    mediaplayer_oyun_sure_bittiginde_calan_muzik?.start()
                }

            }.start()
        }

    }
    fun Mesaj_2lik()
    {
        var UyariMesaji=AlertDialog.Builder(this@Oyun_2lik)
        UyariMesaji.setTitle("                  OYUN BİTTİ")
        if(Alinan_Veri_Oyuncu_Sayisi==1)
        {
            UyariMesaji.setMessage("Oyun Skoru : $Birinci_Oyuncu_Puani \nTekrar Oynamak İster misiniz?")
        }
        else if(Alinan_Veri_Oyuncu_Sayisi==2)
        {
            UyariMesaji.setMessage("1.Oyuncu Skoru : $Birinci_Oyuncu_Puani \n 2.Oyuncu Skoru : $Ikinci_Oyuncu_Puani \nTekrar Oynamak İster misiniz?")
        }
        UyariMesaji.setPositiveButton("Evet",DialogInterface.OnClickListener{dialogInterface, i ->
            Toast.makeText(applicationContext,"Oyun Yeniden Başlıyor.", Toast.LENGTH_SHORT).show()
            mediaplayer_oyun_boyunca_calan_muzik?.stop()
            mediaplayer_oyun_dogru_eslesmede_muzik?.stop()
            mediaplayer_oyun_sure_bitmeden_eslesme_bittiginde_calan_muzik?.stop()
            mediaplayer_oyun_sure_bittiginde_calan_muzik?.stop()
            val intent2= Intent(applicationContext,Giris_Yap_Menu::class.java)
            intent2.putExtra("Yollanan_Veri_Kullanici_Adi",Alinan_Veri_Kullanici_Adi)
            intent2.putExtra("Yollanan_Veri_Sifre",Alinan_Veri_Sifre)
            startActivity(intent2)
            finish()
        })
        UyariMesaji.setNegativeButton("Hayır",DialogInterface.OnClickListener{dialogInterface, i ->
            Toast.makeText(applicationContext,"Menüye Dönülüyor", Toast.LENGTH_SHORT).show()
            mediaplayer_oyun_boyunca_calan_muzik?.stop()
            mediaplayer_oyun_dogru_eslesmede_muzik?.stop()
            mediaplayer_oyun_sure_bitmeden_eslesme_bittiginde_calan_muzik?.stop()
            mediaplayer_oyun_sure_bittiginde_calan_muzik?.stop()
            val intent2= Intent(applicationContext,MainActivity::class.java)
            startActivity(intent2)
            finish()
        })
        UyariMesaji.show()
    }
    fun Resim_Ac_Kapa(deger:Int)
    {
        acilan_kart_kontrolu.add(deger-1)
        if(acilan_kart_kontrolu.count()==2)
        {
            object : CountDownTimer(1000,1000)
            {
                override fun onTick(a: Long) {
                    imageArray[deger-1].visibility= View.VISIBLE
                    imageArray_Kapali[deger-1].visibility= View.INVISIBLE
                }

                override fun onFinish() {
                    acilan_kart_kontrolu_function_2lik()
                }

            }.start()
        }
        else
        {
            imageArray[deger-1].visibility= View.VISIBLE
            imageArray_Kapali[deger-1].visibility= View.INVISIBLE
        }
    }
    fun Tum_Kartlar_Acildimi_Kontrol_2lik()
    {
        var sayi=0
        for(k in (0..3))
        {
            if(imageArray_Sayi_Dizisi[k]==1)
            {
               sayi+=1
            }
        }
        if(sayi==4)
        {
            Mesaj_2lik()
            mediaplayer_oyun_boyunca_calan_muzik?.stop()
            mediaplayer_oyun_dogru_eslesmede_muzik?.stop()
            mediaplayer_oyun_sure_bittiginde_calan_muzik?.stop()
            mediaplayer_oyun_sure_bitmeden_eslesme_bittiginde_calan_muzik?.start()
        }
    }
    fun acilan_kart_kontrolu_function_2lik(){
        if(Imagelere_Atanan_Isimler[acilan_kart_kontrolu[0]]==Imagelere_Atanan_Isimler[acilan_kart_kontrolu[1]])
        {
            if(Alinan_Veri_Oyuncu_Sayisi==1)
            {
                Birinci_Oyuncu_Puani+=((2*Imagelere_Atanan_Puanlar[acilan_kart_kontrolu[0]]*Imagelere_Atanan_Ev_Katsayi[acilan_kart_kontrolu[0]])*(kalan_sure/10)).toFloat()
                Oyun_Sira_Hakki=1
            }
            else if(Alinan_Veri_Oyuncu_Sayisi==2)
            {
                if(Oyun_Sira_Hakki==1)
                {
                    Birinci_Oyuncu_Puani+=(2*Imagelere_Atanan_Puanlar[acilan_kart_kontrolu[0]]*Imagelere_Atanan_Ev_Katsayi[acilan_kart_kontrolu[0]]).toFloat()
                    Oyun_Sira_Hakki=1
                }
                else if(Oyun_Sira_Hakki==2)
                {
                    Ikinci_Oyuncu_Puani+=(2*Imagelere_Atanan_Puanlar[acilan_kart_kontrolu[0]]*Imagelere_Atanan_Ev_Katsayi[acilan_kart_kontrolu[0]]).toFloat()
                    Oyun_Sira_Hakki=2
                }
            }
            mediaplayer_oyun_boyunca_calan_muzik?.pause()
            mediaplayer_oyun_dogru_eslesmede_muzik?.start()
            object : CountDownTimer(3000,1000)
            {
                override fun onTick(p0: Long) {
                }
                override fun onFinish() {
                    mediaplayer_oyun_dogru_eslesmede_muzik?.pause()
                    mediaplayer_oyun_boyunca_calan_muzik?.start()
                }

            }.start()
            imageArray_Sayi_Dizisi[acilan_kart_kontrolu[0]]=1
            imageArray_Sayi_Dizisi[acilan_kart_kontrolu[1]]=1
            imageArray_Kapali_Sayi_Dizisi[acilan_kart_kontrolu[0]]=1
            imageArray_Kapali_Sayi_Dizisi[acilan_kart_kontrolu[1]]=1
            Tum_Kartlar_Acildimi_Kontrol_2lik()
        }
        else if(Imagelere_Atanan_Evler[acilan_kart_kontrolu[0]]==Imagelere_Atanan_Evler[acilan_kart_kontrolu[1]])
        {
            if(Alinan_Veri_Oyuncu_Sayisi==1)
            {
                if(Oyun_Sira_Hakki==1)
                {
                    Birinci_Oyuncu_Puani-=(((Imagelere_Atanan_Puanlar[acilan_kart_kontrolu[0]]+Imagelere_Atanan_Puanlar[acilan_kart_kontrolu[1]])/Imagelere_Atanan_Ev_Katsayi[acilan_kart_kontrolu[0]])*((sure1-kalan_sure)/10)).toFloat()
                    Oyun_Sira_Hakki = 1
                }
            }
            else if(Alinan_Veri_Oyuncu_Sayisi==2)
            {
                if(Oyun_Sira_Hakki==1)
                {
                    Birinci_Oyuncu_Puani-=((Imagelere_Atanan_Puanlar[acilan_kart_kontrolu[0]]+Imagelere_Atanan_Puanlar[acilan_kart_kontrolu[1]])/Imagelere_Atanan_Ev_Katsayi[acilan_kart_kontrolu[0]]).toFloat()
                    Oyun_Sira_Hakki=2
                }
                else if(Oyun_Sira_Hakki==2)
                {
                    Ikinci_Oyuncu_Puani-=((Imagelere_Atanan_Puanlar[acilan_kart_kontrolu[0]]+Imagelere_Atanan_Puanlar[acilan_kart_kontrolu[1]])/Imagelere_Atanan_Ev_Katsayi[acilan_kart_kontrolu[0]]).toFloat()
                    Oyun_Sira_Hakki=1
                }
            }
        }
        else
        {
            if(Alinan_Veri_Oyuncu_Sayisi==1)
            {
                if(Oyun_Sira_Hakki==1)
                {
                    Birinci_Oyuncu_Puani-=((((Imagelere_Atanan_Puanlar[acilan_kart_kontrolu[0]]+Imagelere_Atanan_Puanlar[acilan_kart_kontrolu[1]])/2)*Imagelere_Atanan_Ev_Katsayi[acilan_kart_kontrolu[0]]*Imagelere_Atanan_Ev_Katsayi[acilan_kart_kontrolu[1]])*((sure1-kalan_sure)/10)).toFloat()
                    Oyun_Sira_Hakki=1
                }
            }
            else if(Alinan_Veri_Oyuncu_Sayisi==2)
            {
                if(Oyun_Sira_Hakki==1)
                {
                    Birinci_Oyuncu_Puani-=(((Imagelere_Atanan_Puanlar[acilan_kart_kontrolu[0]]+Imagelere_Atanan_Puanlar[acilan_kart_kontrolu[1]])/2)*Imagelere_Atanan_Ev_Katsayi[acilan_kart_kontrolu[0]]*Imagelere_Atanan_Ev_Katsayi[acilan_kart_kontrolu[1]]).toFloat()
                    Oyun_Sira_Hakki=2
                }
                else if(Oyun_Sira_Hakki==2)
                {
                    Ikinci_Oyuncu_Puani-=(((Imagelere_Atanan_Puanlar[acilan_kart_kontrolu[0]]+Imagelere_Atanan_Puanlar[acilan_kart_kontrolu[1]])/2)*Imagelere_Atanan_Ev_Katsayi[acilan_kart_kontrolu[0]]*Imagelere_Atanan_Ev_Katsayi[acilan_kart_kontrolu[1]]).toFloat()
                    Oyun_Sira_Hakki=1
                }
            }
        }
        birinci_oyuncu_skor_text_2lik.text="1.Oyuncunun Puanı : "+Birinci_Oyuncu_Puani
        if(Alinan_Veri_Oyuncu_Sayisi==2)
        {
            ikinci_oyuncu_skor_text_2lik.text="2.Oyuncunun Puanı : "+Ikinci_Oyuncu_Puani
        }
        acilan_kart_kontrolu.clear()
        Images_Hide_2lik()
    }
    fun Images_Hide_2lik(){
        for(k in (0..3)){
            if(imageArray_Sayi_Dizisi[k]==0)
            {
                imageArray[k].visibility= View.INVISIBLE
            } else
            {
                imageArray[k].visibility= View.VISIBLE
            }

            if(imageArray_Kapali_Sayi_Dizisi[k]==0)
            {
                imageArray_Kapali[k].visibility= View.VISIBLE
            } else
            {
                imageArray_Kapali[k].visibility= View.INVISIBLE
            }
        }
    }
    fun Oyun_2lik_Ipucu(view:View)
    {
        Oyun_2lik_Ipucu_Image.visibility=View.INVISIBLE
        Oyun_2lik_Ipucu_Text.visibility=View.VISIBLE
        kalan_sure_text_2lik.visibility=View.INVISIBLE
        birinci_oyuncu_skor_text_2lik.visibility=View.INVISIBLE
        ikinci_oyuncu_skor_text_2lik.visibility=View.INVISIBLE
        Oyun_2lik_kapat_Image.visibility=View.VISIBLE
        acilan_kart_kontrolu.clear()
        for(k in (0..3)){
                imageArray[k].visibility= View.INVISIBLE
                imageArray_Kapali[k].visibility= View.INVISIBLE
        }
    }
    fun Oyun_2lik_Kapat(view:View)
    {
        Oyun_2lik_Ipucu_Image.visibility=View.VISIBLE
        Oyun_2lik_Ipucu_Text.visibility=View.INVISIBLE
        kalan_sure_text_2lik.visibility=View.VISIBLE
        birinci_oyuncu_skor_text_2lik.visibility=View.VISIBLE
        if(Alinan_Veri_Oyuncu_Sayisi==2)
        {
            ikinci_oyuncu_skor_text_2lik.visibility=View.VISIBLE
        }
        Oyun_2lik_kapat_Image.visibility=View.INVISIBLE
        Images_Hide_2lik()
    }
    fun Oyun_2lik_Geri_Image(view : View) {
        mediaplayer_oyun_boyunca_calan_muzik?.stop()
        mediaplayer_oyun_dogru_eslesmede_muzik?.stop()
        mediaplayer_oyun_sure_bitmeden_eslesme_bittiginde_calan_muzik?.stop()
        mediaplayer_oyun_sure_bittiginde_calan_muzik?.stop()
        val intent2= Intent(applicationContext,Giris_Yap_Menu::class.java)
        intent2.putExtra("Yollanan_Veri_Kullanici_Adi",Alinan_Veri_Kullanici_Adi)
        intent2.putExtra("Yollanan_Veri_Sifre",Alinan_Veri_Sifre)
        startActivity(intent2)
        finish()
    }
    fun Bas1_2lik(view: View)
    {
        Resim_Ac_Kapa(1)
    }
    fun Bas2_2lik(view: View)
    {
        Resim_Ac_Kapa(2)
    }
    fun Bas3_2lik(view: View)
    {
        Resim_Ac_Kapa(3)
    }
    fun Bas4_2lik(view: View)
    {
        Resim_Ac_Kapa(4)
    }
}