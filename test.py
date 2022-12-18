import minsockcontrol

a = minsockcontrol.Client()

a.jseval("Log.info(\"SUS\")")

a.close()