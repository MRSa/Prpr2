package net.osdn.gokigen.watchface.prpr2.complications

import java.util.Random

class DrawableResourceProvider
{
    private val randomGenerator = Random()
    private val imageRscIdList = arrayListOf(
        R.drawable.image001,
        R.drawable.image002,
        R.drawable.image003,
        R.drawable.image004,
        R.drawable.image005,
        R.drawable.image006,
        R.drawable.image007,
        R.drawable.image008,
        R.drawable.image009,
        R.drawable.image010,

        R.drawable.image011,
        R.drawable.image012,
        R.drawable.image013,
        R.drawable.image014,
        R.drawable.image015,
        R.drawable.image016,
        R.drawable.image017,
        R.drawable.image018,
        R.drawable.image019,
        R.drawable.image020,

        R.drawable.image021,
        R.drawable.image022,
        R.drawable.image023,
        R.drawable.image024,
        R.drawable.image025,
        R.drawable.image026,
        R.drawable.image027,
        R.drawable.image028,
        R.drawable.image029,

        R.drawable.image030,
        R.drawable.image031,
        R.drawable.image032,
        R.drawable.image033,
        R.drawable.image034,
        R.drawable.image035,
        R.drawable.image036,
        R.drawable.image037,
        R.drawable.image038,
        R.drawable.image039,
        R.drawable.image040,

        R.drawable.image031,
        R.drawable.image032,
        R.drawable.image033,
        R.drawable.image034,
        R.drawable.image035,
        R.drawable.image036,
        R.drawable.image037,
        R.drawable.image038,
        R.drawable.image039,
        R.drawable.image040,

        R.drawable.image041,
        R.drawable.image042,
        R.drawable.image043,
        R.drawable.image044,
        R.drawable.image045,
        R.drawable.image046,
        R.drawable.image047,
        R.drawable.image048,
        R.drawable.image049,
        R.drawable.image050,

        R.drawable.image051,
        R.drawable.image052,
        R.drawable.image053,
        R.drawable.image054,
        R.drawable.image055,
        R.drawable.image056,
        R.drawable.image057,
        R.drawable.image058,
        R.drawable.image059,
        R.drawable.image060,

        R.drawable.image061,
        R.drawable.image062,
        R.drawable.image063,
        R.drawable.image064,
        R.drawable.image065,
        R.drawable.image066,
        R.drawable.image067,
        R.drawable.image068,
        R.drawable.image069,
        R.drawable.image070,

        R.drawable.image071,
        R.drawable.image072,
        R.drawable.image073,
        R.drawable.image074,
        R.drawable.image075,
        R.drawable.image076,
        R.drawable.image077,
        R.drawable.image078,
        R.drawable.image079,
        R.drawable.image080,

        R.drawable.image081,
        R.drawable.image082,
        R.drawable.image083,
        R.drawable.image084,
        R.drawable.image085,
        R.drawable.image086,
    )

    fun getDrawable() : Int
    {
        try
        {
            return (imageRscIdList[randomGenerator.nextInt(imageRscIdList.count())])
        }
        catch (e: Exception)
        {
            e.printStackTrace()
        }
        return (R.drawable.image000)
    }
}
