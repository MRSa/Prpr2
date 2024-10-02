# Wear OS の Watch Face : インストール＆デバッグの方法 (備忘録)

WFFを使用する場合のウォッチフェイス作成方法。(ビルドやインストールは、コマンドラインで実行する)

## 情報源

* Watch Face Formatについて
  * https://developer.android.com/training/wearables/wff
* サンプルコード
  * https://github.com/android/wear-os-samples/tree/main/WatchFaceFormat
* XML リファレンス
  * https://developer.android.com/training/wearables/wff/watch-face

## ビルド方法

```
  gradlew assembleDebug
```

## インストール方法

```
  adb install watchface/build/outputs/apk/debug/watchface-debug.apk
```

インストール後、Wear OS端末側で操作し、ウォッチフェイスを切り替える。
