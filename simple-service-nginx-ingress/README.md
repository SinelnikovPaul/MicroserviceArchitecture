# Установка
```kubectl apply -f manifests/.```

# Описание
Сервер на Java представляет один эндпоинт
* `/health` возвращает `{"status": "OK"}`

# Tecтирование
* `curl arch.homework/otusapp/something/health`
* `curl arch.homework/health`


Ingress форвардит все запросы с `/otusapp/{student name}/*` на сервис с rewrite-ом пути. Где `{student name}` - это имя студента.
Например: `curl arch.homework/otusapp/aeugene/health` -> рерайт пути на `arch.homework/health`