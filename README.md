# Introduction
This is only a prototype, used for better understanding of the ddata flow from front-end to backend then back to frontend.
It uses SparingBoot + Vue.js since for such a micro service, it may be too generous to assign separate severs to them, not to say need to consider the CORS problems sometimes.
It is tough since the time limitation is quite restrict, but anyway, I ended up with a runnable site (not too ugly at least) and implement simple data interaction. 
That is all a (general/basic) prototype needs to do for now.

# fileProcessorDemo
 url-mapping temporarily failed.
 Not sure why, I extends the configure support, seems not work as expected at all...
 May investigate later.....

 
 # Source Usage
  This is project's source code, so you may need to download the code, and run it locally based on it.
  applications.properties listed all the configuration parameters.
  Packages you need to prepare before you start working:
    NPM, IDE (or emacs if you...), nodeJS
  /web folder is for frontend while /server folder is for backend.
  You need to:
      1. go to /web folder and exec "npm install" to get node-modules folder.
      2. run npm run dev to package /web folder and start the front-end service.
      3. run bootRun under Application of /server folder to start the back-end service.
      
 Hope it can relieve your confusion if you also need to seek for a way for full-stack development but does not want to separate them.
 This is a good way to do it, from my side. 
 Enjoy it.
 

