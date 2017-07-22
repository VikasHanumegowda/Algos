import requests,sys

r = requests.get('https://api.github.com/events')

print(str(r.url)+"\n"+sys.version)
print(r.content)

def something():
    pass
r = property(fget=something, fset= )