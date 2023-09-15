package com.example.andersenfragments.Data

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class CatRepository {

    val listCat: List<Cat> = listOf(
        Cat(1, KEKS, CAT, 22),
        Cat(2, MUR, CAT, 22),
        Cat(3, BAR, CAT, 22),
        Cat(4, KUR, CAT, 22),
        Cat(5, PUSH, CAT, 33),
        Cat(6, TSARAPKA, CAT, 33),
        Cat(7, SHU, CAT, 44),
        Cat(8, KOTE, CAT, 55),
    )


    suspend fun getData(): Flow<Cat> {
        return flow {
            for (i in listCat) {
                delay(1000)
                emit(i)
            }
        }
    }
}

const val CAT = "The Cat"
const val TSARAPKA = "Tsarapka"
const val KEKS = "Keksik"
const val MUR = "Murzik"
const val BAR = "Barsik"
const val KUR = "Kurlandsky"
const val PUSH = "Pushik"
const val SHU = "Shurik"
const val KOTE = "Kote"