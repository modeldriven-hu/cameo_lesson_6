# Cameo/MagicDraw plugin development - Lesson 6

This lesson explains how to work with selection.

# Requirements

- Cameo/MagicDraw latest 
- Java JDK 11 
- Maven

# Usage

## Check out the repository

`git clone https://github.com/modeldriven-hu/cameo_lesson_6.git`

## Configure environment variable

Configure Cameo/MagicDraw root directory according to local setup, for example:

`set CAMEO_ROOT=C:/home/Tools/Cameo`

or when using PowerShell:

`$env:CAMEO_ROOT = "C:/Home/Tools/Cameo"`

## Build project

`mvn package`

## Extract into Cameo plugins folder

Extract `target/hu.modeldriven.cameo.lesson6.zip` into `CAMEO_ROOT/plugins`

## Restart

Restart CAMEO