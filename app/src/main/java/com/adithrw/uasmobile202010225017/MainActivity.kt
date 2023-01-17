package com.adithrw.uasmobile202010225017

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.adithrw.uasmobile202010225017.databinding.ActivityMainBinding
import java.text.NumberFormat
import java.util.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnHitung.setOnClickListener(this)


    }

    override fun onClick(v: View?) {
        binding.tvPenerimaan.text = "PENERIMAAN"
        binding.tvGajiPokok.text = "Gaji Pokok"
        binding.tvUangLembur.text = "Uang Lembur"
        binding.tvTunjangan.text = "Tunjangan Transport"
        binding.tvMakan.text = "Tunjangan Makan"
        binding.tvGolongan.text = "Tunjangan Golongan"
        binding.tvInsentif.text = "Insentif"
        binding.tvKotor.text = "Jumlah Gaji Kotor"

        binding.tvPotongan.text = "POTONGAN"
        binding.tvPph.text = "PPh21"
        binding.tvKesehatan.text = "BPJS Kesehatan"
        binding.tvTenaga.text = "BPJS Ketenagakerjaan"
        binding.tvKoperasi.text = "Koperasi"
        binding.tvPotongan.text = "POTONGAN"
        binding.tvJumlahPotongan.text = "Jumlah Potongan"

        binding.tvBersih.text = "Gaji Bersih"


        binding.hr1.visibility = View.VISIBLE
        binding.hr2.visibility = View.VISIBLE

       var gajiPokok = binding.etGaji.text
       var lembur = binding.etLembur.text
       var golongan = binding.etGolongan.text
        var insentif = binding.etInsenstif.text
        var hariKerja = binding.etJumlahHari.text

        binding.valueGajiPokok.text = convertFormat(gajiPokok.toString().toDouble())
        binding.valueUangLembur.text = convertFormat(lembur.toString().toDouble())
        binding.valueInsentif.text = convertFormat(insentif.toString().toDouble())

        var transport = hariKerja.toString().toInt() * 15000
        binding.valueTunjangan.text = convertFormat(transport.toString().toDouble())

        var makan = hariKerja.toString().toInt() * 20000
        binding.valueMakan.text = convertFormat(makan.toString().toDouble())

        var tunjanganGolongan = 0
        if(golongan.toString().toInt() == 1){
            tunjanganGolongan = 100000
        } else if (golongan.toString().toInt() == 2){
            tunjanganGolongan = 200000
        } else if (golongan.toString().toInt() == 3){
            tunjanganGolongan = 300000
        } else if (golongan.toString().toInt() == 4){
            tunjanganGolongan = 400000
        } else if (golongan.toString().toInt() == 5){
            tunjanganGolongan = 500000
        } else {
            tunjanganGolongan = 0
        }

        binding.valueGolongan.text = convertFormat(tunjanganGolongan.toString().toDouble())
        var total = gajiPokok.toString().toInt() + lembur.toString().toInt() + insentif.toString().toInt() + transport + makan + tunjanganGolongan

        binding.valueKotor.text = convertFormat(total.toDouble())

        var pph = total * 0.1
        binding.valuePph.text = convertFormat(pph)

        var kesehatan = total * 0.03
        binding.valueKesehatan.text = convertFormat(kesehatan)

        var tenaga = total * 0.02
        binding.valueTenaga.text = convertFormat(tenaga)

        var koperasi = 100000
        binding.valueKoperasi.text = convertFormat(koperasi.toDouble())

        var potongan = pph + kesehatan + tenaga + koperasi
        binding.valueJumlahPotongan.text = convertFormat(potongan)

        var bersih = total - potongan
        binding.valueBersih.text = convertFormat(bersih)


    }

    private fun convertFormat(number: Double): String? {
        val localeID = Locale("in", "ID")
        val formatRupiah = NumberFormat.getCurrencyInstance(localeID)
        return formatRupiah.format(number)
    }
}