package com.malaika18khan.visithyderabad.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.malaika18khan.visithyderabad.R

data class Place(
    @DrawableRes val imageResourceId: Int,
    @StringRes val name: Int,
    @StringRes val description: Int
)

val places = listOf(
    Place(R.drawable.sindh_museum, R.string.p1_name, R.string.p1_description),
    Place(R.drawable.tombs_of_talpur_mirs, R.string.p2_name, R.string.p2_description),
    Place(R.drawable.mukhi_house, R.string.p3_name, R.string.p3_description),
    Place(R.drawable.kotri_barrage, R.string.p4_name, R.string.p4_description),
    Place(R.drawable.badshahi_bungalow, R.string.p5_name, R.string.p5_description),
    Place(R.drawable.rani_bagh, R.string.p6_name, R.string.p6_description),
    Place(R.drawable.pakka_qilla, R.string.p7_name, R.string.p7_description),
    Place(R.drawable.hosh_m_sheedi_monument, R.string.p8_name, R.string.p8_description),
    Place(R.drawable.navalrai_clock_tower, R.string.p9_name, R.string.p9_description),
    Place(R.drawable.qadam_gah, R.string.p10_name, R.string.p10_description),
    Place(R.drawable.kotri_bridge, R.string.p11_name, R.string.p11_description),
    Place(R.drawable.hyd_gymkhana, R.string.p12_name, R.string.p12_description),
    Place(R.drawable.hasrat_mohani_library, R.string.p13_name, R.string.p13_description),
    Place(R.drawable.niaz_stadium, R.string.p14_name, R.string.p14_description),
    Place(R.drawable.ganjo_takkar, R.string.p15_name, R.string.p15_description),
    Place(R.drawable.auto_bhan, R.string.p16_name, R.string.p16_description),
    Place(R.drawable.tomb_ghulam_shah_kalhoro, R.string.p17_name, R.string.p17_description),
    Place(R.drawable.shahi_bazaar, R.string.p18_name, R.string.p18_description),
    Place(R.drawable.eid_gah, R.string.p19_name, R.string.p19_description),
    Place(R.drawable.uos_elsa_kazi_campus, R.string.p20_name, R.string.p20_description),
    Place(R.drawable.boulevard_mall, R.string.p21_name, R.string.p21_description),
    Place(R.drawable.dubbo_war_memorial, R.string.p22_name, R.string.p22_description)
)