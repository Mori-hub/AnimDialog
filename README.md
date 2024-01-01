
# Animation Header Dialog

This is kind of a Dialog which is includes simple animations in the header of it.
## Features

- Simple animation
- Support all languages
- Unlimited call functions
- Easy Use
- All Dialog: Welcome, Exit, Warning, Info, Delete, Success
- Easy Theme
- Custom Dialog


## Installation

Install my-project with https://jitpack.io/


```bash
  dependencies {
	         implementation 'com.github.Mori-hub:AnimDialog:1.0.13'
	}
```
## Version

<img alt="JitPack" src="https://img.shields.io/jitpack/v/github/Mori-hub/AnimDialog">

## TOML Kotlin
1. build.gradle.kts:
```javascript
dependencies
   { ...
   implementation (libs.anim.dialogs.mori)
   }
  ``` 
3. libs.version.toml:
```javascript
   [versions]

   anim_dialogs="1.0.14"

   [libraries]

   anim_dialogs_mori = { module = "com.github.Mori-hub:AnimDialog", version.ref = "anim_dialogs" }
```

## Usage

```javascript
    // Call Lib (Small or Large)
        val animDialog = AnimDialog(this)
    // Main Way
        animDialog.welcome(
            description: String,
            titleOfPositiveButton: String? = null,
            positiveButtonFunction: (() -> Unit)? = null)
```
## Explain
* **ButtonFunction** : Here you can add your Unit, Method or Calss. (such as Toast)
* **null** : For any attributes you can put null then use defualt
* **Show Dialog**: When you call any method this will show, so please ues in side OnClick.
* **Colors**: A color must be a name ("yellow") or a Hex code ("#DFD3C3")
## Examples
```javascript
        // Welcome Dialog
            
            animDialog.welcome("Welcome to this", null, {})
        
        // Exit Dialog
            animDialog.exit("Do you want exit?", null, "Cancel", {
                Toast.makeText(this, "goodbye", Toast.LENGTH_SHORT).show()
            }, this)
        // Rate Dialog
            animDialog.rate("Do you enjoy it? \n Please rate us", "Rate", "Maybe later")
        
        // Information Dialog
            animDialog.info("This message inform you about this", "Got it")
        
        // Warning Dialog
            animDialog.warning("Attention! \n You are going in bad way", "Accept", "Ignore", {})
        
        
        // Delete Dialog
            animDialog.del("Do you want Delete it!? \n You will lose this",
            "Delete",
            "Ignore",
            { Toast.makeText(this, "It's deleted!", Toast.LENGTH_SHORT).show() })

        

```
## Sample

```javascript
    // Editable Dialog
        animDialog.simple(
            headerImage = android.R.drawable.presence_video_online,
            description = "Hi thi is a test",
            titleOfPositiveButton = "OK",
            titleOfNegativeButton = "Cancel",
            positiveButtonFunction = {
                Toast.makeText(
                    this,
                    "Click on OK",
                    Toast.LENGTH_SHORT
                ).show()
            },
            negativeButtonFunction = {
                Toast.makeText(
                    this,
                    "Click on Cancel",
                    Toast.LENGTH_SHORT
                ).show()
            }
        )
```

## Optinal Theme

```javascript
    // You set theme for all dialoges 
        animDialog.dialogTheme(
            true,
            "White",
            "#DFD3C3", "black",
            "#000B49", "yellow"
        )
```
## Screenshots

One Header

<img src="https://user-images.githubusercontent.com/53067774/160858704-e1cf1aa2-97b1-4316-ac60-7c00ce295976.jpg" width="13%"></img> <img src="https://user-images.githubusercontent.com/53067774/160858713-29e5770f-c8ad-4e8f-9677-f36fe7c4350b.jpg" width="13%"></img> <img src="https://user-images.githubusercontent.com/53067774/160858717-1da18815-b570-4715-8d34-38e50dc91cba.jpg" width="13%"></img> <img src="https://user-images.githubusercontent.com/53067774/160858719-bed28e8d-a90a-47f1-8d74-813138edbf5a.jpg" width="13%"></img> <img src="https://user-images.githubusercontent.com/53067774/160858722-cd74b838-5943-450e-85cb-0845094ce428.jpg" width="13%"></img> <img src="https://user-images.githubusercontent.com/53067774/160858732-fbe7717c-e7e5-440c-8af5-e6595ca211b5.jpg" width="13%"></img> <img src="https://user-images.githubusercontent.com/53067774/160858775-081fb05e-7107-4504-9452-0ecbb1deb665.jpg" width="13%"></img>

Two Headers

<img src="https://user-images.githubusercontent.com/53067774/160859376-391fb014-df75-40d9-aae2-056de3d0d3d8.jpg" width="13%"></img>


## Gifs

<img src="https://user-images.githubusercontent.com/53067774/160862797-5877e9f3-83ca-4085-ae1b-18cc4d4524ad.gif" width="15%"></img>

## 🚀 About Me
I'm a full stack developer...find me in Google Play Store


## 🛠 Skills
Java, Kotlin, CSS....


## Tech Stack

**Important:** 

For Gradle 8.4 dependency use TOML Kotlin & jitpack.io Please use this way : https://stackoverflow.com/a/77630488

**Update:** DeC 2023


## 🔗 Links
[![portfolio](https://img.shields.io/badge/my_portfolio-000?style=for-the-badge&logo=ko-fi&logoColor=white)](https://github.com/Mori-hub)
[![linkedin](https://img.shields.io/badge/linkedin-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/)
[![twitter](https://img.shields.io/badge/twitter-1DA1F2?style=for-the-badge&logo=twitter&logoColor=white)](https://twitter.com/)
[![Google](https://img.shields.io/badge/My%20Apps-Google%20Play%20Store-green?style=for-the-badge&logo=googleplay)](https://play.google.com/store/search?q=pub:Smart%20rabit&c=apps)


## Feedback

If you have any feedback, please reach out to us at ✉️ SR-App@outlook.com


## License

[MIT](https://choosealicense.com/licenses/mit/)

