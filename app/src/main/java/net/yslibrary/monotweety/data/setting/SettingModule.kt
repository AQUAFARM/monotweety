package net.yslibrary.monotweety.data.setting

import android.content.Context
import com.f2prateek.rx.preferences.RxSharedPreferences
import dagger.Module
import dagger.Provides
import net.yslibrary.monotweety.base.di.AppScope
import net.yslibrary.monotweety.base.di.Names
import javax.inject.Named

/**
 * Created by yshrsmz on 2016/09/29.
 */
@Module
class SettingModule {

  @AppScope
  @Provides
  fun provideSettingPreferences(@Named(Names.FOR_APP) context: Context): RxSharedPreferences {
    val prefs = context.getSharedPreferences("net.yslibrary.monotweety.prefs.settings", Context.MODE_PRIVATE)
    return RxSharedPreferences.create(prefs)
  }

  @AppScope
  @Provides
  fun provideSettingDataManager(prefs: RxSharedPreferences): SettingDataManager {
    return SettingDataManagerImpl(prefs)
  }

  interface Provider {
    fun settingDataManager(): SettingDataManager
  }
}