package com.example.premierleague

import com.agoda.kakao.KButton
import com.agoda.kakao.KTextView
import com.agoda.kakao.Screen

class KakaoScreen:Screen<KakaoScreen>(){

    val nameTextView : KTextView =
        KTextView{withId(R.id.name)}
    val webTextView : KTextView =
        KTextView{withId(R.id.website)}
    val colorTextView : KTextView =
        KTextView{withId(R.id.clubColor)}
    val venueTextView : KTextView =
        KTextView{withId(R.id.venue)}
    val infoButton : KButton =
        KButton{withId(R.id.info)}
}