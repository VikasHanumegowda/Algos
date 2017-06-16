from urllib.request import urlopen
import webbrowser

url = 'https://google.com'
response = urlopen(url)
print(response.read())



f = open('helloworld.html','w')

message = """<html>
<head></head>
<body><p>Hello World!</p></body>
</html>"""

f.write(str(response.read()))
f.close()

#Change path to reflect file location
filename = '/Users/vikashanumegowda/PycharmProjects/Algos' + 'helloworld.html'
print("hello")
webbrowser.open_new_tab(filename)