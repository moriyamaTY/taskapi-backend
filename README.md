# taskapi_backend

## 概要
このAPIは、タスクを管理するためのREST APIです。
タスクの作成、一覧取得、詳細取得、更新、削除ができます。

## 使用技術

- Java
- Spring Boot
- Spring Data JPA
- H2 database
- Apache Maven

## 仕様
### タスク作成

POST /tasks

ヘッダー
X-USER-ID: userId

リクエスト例
```json
{
    "title": "タスク１",
    "description": "これはuser1のタスクです。",
    "status": "TODO"
}
```

レスポンス例
```json
{
    "id": 1,
    "title": "タスク１",
    "description": "これはuser1のタスクです。",
    "status": "TODO",
    "createdAt": "2026-03-09T17:07:11",
    "updatedAt": "2026-03-09T17:07:11"
}
```
### タスク取得

GET /tasks/{id}

ヘッダー
X-USER-ID: userId

レスポンス例
```json
{
    "id": 1,
    "title": "タスク１",
    "description": "これはuser1のタスクです。",
    "status": "TODO",
    "createdAt": "2026-03-09T17:07:11",
    "updatedAt": "2026-03-09T17:07:11"
}
```

### タスク更新

PUT /tasks/{id}

### タスク削除

DELETE /tasks/{id}

## 起動方法

1. リポジトリをクローン  
```git clone <https://github.com/moriyamaTY/taskapi-backend>```
2. プロジェクトフォルダに移動  
```cd taskapi```
3. アプリケーションを起動  
```mvn spring-boot:run```
4. Ｈ２コンソール（必要に応じて）  
```http://localhost:8080/h2-console```

## 工夫した点

・controller / Service / Repository のレイヤー構造に倣い、役割を分離させました。

・DTO（Data Transfer Object）を使い、入力時にEntityに直接触れられない設計にしました。

・ユーザー識別はX-USER-IDヘッダーで行いました。

・他ユーザーのタスクを取得できないように、タスク取得時にuserIdを含めた検索をする設計にしました。

・タスクが存在しない場合は、HTTPステータス404を返すように例外処理を実装しました。

## ディレクトリ構成
```
taskapi
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com/example/taskapi
│   │   │       ├── controller
│   │   │       ├── service
│   │   │       ├── repository
│   │   │       ├── dto
│   │   │       └── entity
│   │   └── resources
└── pom.xml
```