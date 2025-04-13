CREATE TABLE "users" (
    "id" UUID PRIMARY KEY,
    "email" VARCHAR UNIQUE NOT NULL,
    "created_at" TIMESTAMPTZ NOT NULL,
    "updated_at" TIMESTAMPTZ NOT NULL
);

CREATE TABLE "accounts" (
    "provider" VARCHAR NOT NULL,
    "hash" VARCHAR NOT NULL,
    "created_at" TIMESTAMPTZ NOT NULL,
    "updated_at" TIMESTAMPTZ NOT NULL,
    "user_id" UUID NOT NULL REFERENCES "users" ("id") ON DELETE CASCADE,
    PRIMARY KEY ("provider", "user_id")
);