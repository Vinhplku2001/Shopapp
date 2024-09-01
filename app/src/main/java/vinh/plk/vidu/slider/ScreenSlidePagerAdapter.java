package vinh.plk.vidu.slider;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import vinh.plk.vidu.Fragment1;
import vinh.plk.vidu.Fragment2;
import vinh.plk.vidu.Fragment3;
import vinh.plk.vidu.MainActivity;

public class ScreenSlidePagerAdapter extends FragmentStateAdapter {
    public ScreenSlidePagerAdapter(MainActivity mainActivity) {
        super(mainActivity);
    }

    //@NonNull
    //@NotNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new Fragment1();
            case 1:
                return new Fragment2();
            case 2:
                return new Fragment3();
            default:
                return null;
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}


