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
  adb install Prpr2/build/outputs/apk/debug/prpr2-debug.apk
  adb install watchface/build/outputs/apk/debug/watchface-debug.apk
```

インストール後、Wear OS端末側で操作し、ウォッチフェイスを切り替える。

## 制約事項

画像切り替えの周期が長い。（5分設定...エミュレータだと10分程度で切り替わる）
代替手段として、画面タップで画像を更新するように変更した。

## 参考： 画像を生成したプロンプト

```
    mini, mini dress, slender, portrait, small breasts, shy, glasses, natural make up, school uniform, short sleeve shirt, short hair, hair over one eye, black hair, 1girl
```
