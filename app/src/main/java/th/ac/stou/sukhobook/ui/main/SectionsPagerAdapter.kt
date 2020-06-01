package th.ac.stou.sukhobook.ui.main

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import th.ac.stou.sukhobook.R

private val TAB_TITLES = arrayOf(
    R.string.tab_text_magazine,
    R.string.tab_text_textbook,
    R.string.tab_text_fav,
    R.string.tab_text_location
)

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
class SectionsPagerAdapter(private val context: Context, fm: FragmentManager) :
    FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        if (position==0)
            return MagazineFragment.newInstance("", "")
        else if (position==1)
            return TextbookFragment.newInstance("", "")
        else if (position==2)
            return FavFragment.newInstance("", "")
        else if (position==3)
            return LocationFragment.newInstance("", "")
        else
            return PlaceholderFragment.newInstance(position+1)
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return context.resources.getString(TAB_TITLES[position])
    }

    override fun getCount(): Int {
        // Show 2 total pages.
        return 4
    }
}