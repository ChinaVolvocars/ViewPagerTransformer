package com.example;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.example.viewpager.R;

public class ViewPagerActivity extends AppCompatActivity {

  ViewPager2 myViewPager2;
  MyAdapter MyAdapter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_java);

    myViewPager2 = findViewById(R.id.viewpager);

    MyAdapter = new MyAdapter(this);
    myViewPager2.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);
    myViewPager2.setAdapter(MyAdapter);
    myViewPager2.setOffscreenPageLimit(3);

    float pageMargin = getResources().getDimensionPixelOffset(R.dimen.pageMargin);
    float pageOffset = getResources().getDimensionPixelOffset(R.dimen.offset);
    myViewPager2.setPageTransformer((page, position) -> {
      float myOffset = position * -(2 * pageOffset + pageMargin);
      if (position < -1) {
        page.setTranslationX(-myOffset);
      } else if (position <= 1) {
        float scaleFactor = Math.max(0.7f, 1 - Math.abs(position - 0.14285715f));
        page.setTranslationX(myOffset);
        page.setScaleY(scaleFactor);
        page.setAlpha(scaleFactor);
      } else {
        page.setAlpha(0);
        page.setTranslationX(myOffset);
      }
    });
//    myViewPager2.setPageTransformer(new ViewPager2.PageTransformer() {
//      @Override
//      public void transformPage(@NonNull View page, float position) {
//        float myOffset = position * -(2 * pageOffset + pageMargin);
//        if (myViewPager2.getOrientation() == ViewPager2.ORIENTATION_HORIZONTAL) {
//          if (ViewCompat.getLayoutDirection(myViewPager2) == ViewCompat.LAYOUT_DIRECTION_RTL) {
//            page.setTranslationX(-myOffset);
//          } else {
//            page.setTranslationX(myOffset);
//          }
//        } else {
//          page.setTranslationY(myOffset);
//        }
//      }
//    });
  }
}
