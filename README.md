
# Animations & Dialoges

This is kind of a dialog. This is a simple and nice animated dialoge .
## Features

- Header buncing Image
- Support all languages
- Unlimited call fuctions
- Easy Use
- All Dialoges: Welcome, Exit, Warning, Info, Delete, Success
- Easy Theme 
- Custom Dialog


## Installation

Install my-project with https://jitpack.io/

```bash
  dependencies {
	        implementation 'com.github.Mori-hub:Number-Separator:0.1.0'
	}
```
    
## Usage

```javascript
    // Call Lib (Small or Large)
         val animDialog = AnimDialog(this) 
    // Main Way
        animDialog.welcome(description: String,
                    titleOfPositiveButton: String? = null,     
                    positiveButtonFunction: (() → Unit)? = null )
```
## Explain
* **ButtonFunction** : Here you can add your Unit, Method or Calss. (such as Toast)
* **null** : For any attributes you can put null then use defualt
* **Show Dialog**: When you call any method this will show, so please ues in side OnClick. 
* **Colors**: A color must be a name ("yellow") or a Hex code ("#DFD3C3") 
## Examples
```javascript
        // Welcome Dialog
        findViewById<Button>(R.id.button).setOnClickListener {
             animDialog.welcome("Welcome to this", null, {})
        }
        // Exit Dialog
        findViewById<Button>(R.id.button2).setOnClickListener {
            animDialog.exit("Do you want exit?", null, "Cancel", {
                Toast.makeText(this, "goodbye", Toast.LENGTH_SHORT).show()
            }, this)
        }
        // Rate Dialog
        findViewById<Button>(R.id.button3).setOnClickListener {
            animDialog.rate("Do you enjoy it? \n Please rate us", "Rate", "Maybe later")
        }
        // Information Dialog
        findViewById<Button>(R.id.button4).setOnClickListener {
             animDialog.info("This is an App just show Information! 😎", "info",
                { Toast.makeText(this, "Help me", Toast.LENGTH_SHORT).show() })
        }
        // Warning Dialog
        findViewById<Button>(R.id.button5).setOnClickListener {
            animDialog.warning("Attention, this is yellow area!", null, null, null)

        }

        // Delete Dialog
        findViewById<Button>(R.id.button6).setOnClickListener {
            animDialog.del("Do you want delete this file?", null, null, null)

        }

        // Success Dialog
        findViewById<Button>(R.id.button7).setOnClickListener {
            animDialog.success("The process is successful!", null, null, null)

        }

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

## TwoHeader 
```javascript
    // Call Lib (Small or Large)
         val animDialog = AnimDialog(this) 
    // Main Way
        twoHeaders.simple(
                    title = "Exit App",
                    headerImage = null,
                    description = "Hi thi is a test",
                    titleOfPositiveButton = "OK",
                    titleOfNegativeButton = "Ignore",
                    positiveButtonFunction = {
                        Toast.makeText(this, "OK", Toast.LENGTH_SHORT).show()
                    },
                    negativeButtonFunction = {
                        Toast.makeText(this, "Ignore", Toast.LENGTH_SHORT).show()
                    }
                )
```
## Screenshots


| col 1      | col 2      |
|------------|-------------|
| <img src="" width="250"> | <img src="" width="250"> |

## Gifs
![see](https://mir-s3-cdn-cf.behance.net/project_modules/max_1200/5eeea355389655.59822ff824b72.gif)

<img src="./assets/image.gif" width="50%" height="50%"/>

## 🚀 About Me
I'm a full stack developer...


## 🛠 Skills
Java, Kotlin, CSS....


## Tech Stack

**Important:** For Gradle 7.2 & jitpack.io Please use this way : https://stackoverflow.com/a/71603699/12272687

**Update:** March 2022


## 🔗 Links
[![portfolio](https://img.shields.io/badge/my_portfolio-000?style=for-the-badge&logo=ko-fi&logoColor=white)](https://github.com/Mori-hub)
[![linkedin](https://img.shields.io/badge/linkedin-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/)
[![twitter](https://img.shields.io/badge/twitter-1DA1F2?style=for-the-badge&logo=twitter&logoColor=white)](https://twitter.com/)


## Feedback

If you have any feedback, please reach out to us at SR-App@outlook.com


## License

[MIT](https://choosealicense.com/licenses/mit/)

