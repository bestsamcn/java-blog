/*
 Navicat Premium Data Transfer

 Source Server         : blog
 Source Server Type    : PostgreSQL
 Source Server Version : 90514
 Source Host           : localhost:5432
 Source Catalog        : blog
 Source Schema         : public

 Target Server Type    : PostgreSQL
 Target Server Version : 90514
 File Encoding         : 65001

 Date: 12/09/2018 19:29:35
*/


-- ----------------------------
-- Table structure for article
-- ----------------------------
DROP TABLE IF EXISTS "public"."article";
CREATE TABLE "public"."article" (
  "id" char(32) COLLATE "pg_catalog"."default" NOT NULL,
  "creator" char(32) COLLATE "pg_catalog"."default" NOT NULL,
  "category" char(32) COLLATE "pg_catalog"."default" NOT NULL,
  "tag" char(32) COLLATE "pg_catalog"."default" NOT NULL,
  "thumnail" varchar(250) COLLATE "pg_catalog"."default",
  "poster" varchar(250) COLLATE "pg_catalog"."default",
  "content" text COLLATE "pg_catalog"."default",
  "title" varchar(120) COLLATE "pg_catalog"."default",
  "pinyin" varchar(250) COLLATE "pg_catalog"."default",
  "createTime" timestamp(0) NOT NULL DEFAULT now(),
  "lastEditTime" timestamp(0) NOT NULL DEFAULT now(),
  "categoryName" varchar(50) COLLATE "pg_catalog"."default",
  "tagName" varchar(50) COLLATE "pg_catalog"."default",
  "readNum" int4 NOT NULL,
  "commentNum" int4 NOT NULL,
  "codeContent" text COLLATE "pg_catalog"."default",
  "previewText" varchar(250) COLLATE "pg_catalog"."default",
  "likeNum" int4,
  "private" bool
)
;
COMMENT ON COLUMN "public"."article"."id" IS 'id';
COMMENT ON COLUMN "public"."article"."creator" IS 'creator';
COMMENT ON COLUMN "public"."article"."category" IS 'category';
COMMENT ON COLUMN "public"."article"."tag" IS 'tag';
COMMENT ON COLUMN "public"."article"."thumnail" IS 'thumnail';
COMMENT ON COLUMN "public"."article"."poster" IS 'poster';
COMMENT ON COLUMN "public"."article"."content" IS 'content';
COMMENT ON COLUMN "public"."article"."title" IS 'title';
COMMENT ON COLUMN "public"."article"."pinyin" IS 'pinYin';
COMMENT ON COLUMN "public"."article"."createTime" IS 'createTime';
COMMENT ON COLUMN "public"."article"."lastEditTime" IS 'lastEditTime';
COMMENT ON COLUMN "public"."article"."categoryName" IS 'categoryName';
COMMENT ON COLUMN "public"."article"."tagName" IS 'tagName';
COMMENT ON COLUMN "public"."article"."readNum" IS 'readNum';
COMMENT ON COLUMN "public"."article"."commentNum" IS 'commentNum';
COMMENT ON COLUMN "public"."article"."codeContent" IS 'codeContent';
COMMENT ON COLUMN "public"."article"."previewText" IS 'previewText';
COMMENT ON COLUMN "public"."article"."likeNum" IS 'likeNum';
COMMENT ON TABLE "public"."article" IS 'article';

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS "public"."category";
CREATE TABLE "public"."category" (
  "id" char(32) COLLATE "pg_catalog"."default" NOT NULL,
  "name" varchar(50) COLLATE "pg_catalog"."default" NOT NULL,
  "createTime" timestamp(0) NOT NULL DEFAULT now(),
  "clickNum" int4 DEFAULT 0
)
;
COMMENT ON COLUMN "public"."category"."id" IS 'id';
COMMENT ON COLUMN "public"."category"."name" IS 'name';
COMMENT ON COLUMN "public"."category"."createTime" IS 'createTime';
COMMENT ON COLUMN "public"."category"."clickNum" IS 'clickNum';
COMMENT ON TABLE "public"."category" IS 'category';

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS "public"."comment";
CREATE TABLE "public"."comment" (
  "id" char(32) COLLATE "pg_catalog"."default" NOT NULL,
  "article" char(32) COLLATE "pg_catalog"."default" NOT NULL,
  "content" varchar(250) COLLATE "pg_catalog"."default" NOT NULL,
  "createTime" timestamp(0) NOT NULL DEFAULT now(),
  "createName" varchar(26) COLLATE "pg_catalog"."default" NOT NULL,
  "createEmail" varchar(250) COLLATE "pg_catalog"."default" NOT NULL,
  "createIp" varchar(15) COLLATE "pg_catalog"."default",
  "likeNum" int4 DEFAULT 0,
  "parentComment" char(32) COLLATE "pg_catalog"."default" NOT NULL
)
;
COMMENT ON COLUMN "public"."comment"."id" IS 'id';
COMMENT ON COLUMN "public"."comment"."article" IS 'article';
COMMENT ON COLUMN "public"."comment"."content" IS 'content';
COMMENT ON COLUMN "public"."comment"."createTime" IS 'createTime';
COMMENT ON COLUMN "public"."comment"."createName" IS 'createName';
COMMENT ON COLUMN "public"."comment"."createEmail" IS 'createEmail';
COMMENT ON COLUMN "public"."comment"."createIp" IS 'createIp';
COMMENT ON COLUMN "public"."comment"."likeNum" IS 'likeNum';
COMMENT ON COLUMN "public"."comment"."parentComment" IS 'parentComment';
COMMENT ON TABLE "public"."comment" IS 'comment';

-- ----------------------------
-- Table structure for count
-- ----------------------------
DROP TABLE IF EXISTS "public"."count";
CREATE TABLE "public"."count" (
  "id" char(32) COLLATE "pg_catalog"."default" NOT NULL,
  "accessIp" char(15) COLLATE "pg_catalog"."default",
  "apiName" varchar(250) COLLATE "pg_catalog"."default" NOT NULL,
  "country" varchar(250) COLLATE "pg_catalog"."default",
  "province" varchar(250) COLLATE "pg_catalog"."default",
  "city" varchar(250) COLLATE "pg_catalog"."default",
  "district" varchar(250) COLLATE "pg_catalog"."default",
  "createTime" timestamp(6) DEFAULT now()
)
;
COMMENT ON COLUMN "public"."count"."id" IS 'id';
COMMENT ON COLUMN "public"."count"."accessIp" IS 'accessip';
COMMENT ON COLUMN "public"."count"."apiName" IS 'apiName';
COMMENT ON COLUMN "public"."count"."country" IS 'country';
COMMENT ON COLUMN "public"."count"."province" IS 'province';
COMMENT ON COLUMN "public"."count"."city" IS 'city';
COMMENT ON COLUMN "public"."count"."district" IS 'district';
COMMENT ON TABLE "public"."count" IS 'count';

-- ----------------------------
-- Table structure for hot
-- ----------------------------
DROP TABLE IF EXISTS "public"."hot";
CREATE TABLE "public"."hot" (
  "id" char(32) COLLATE "pg_catalog"."default" NOT NULL,
  "name" varchar(50) COLLATE "pg_catalog"."default" NOT NULL,
  "createTime" timestamp(0) NOT NULL DEFAULT now(),
  "hotcount" int4 DEFAULT 0
)
;
COMMENT ON COLUMN "public"."hot"."id" IS 'id';
COMMENT ON COLUMN "public"."hot"."name" IS 'name';
COMMENT ON COLUMN "public"."hot"."createTime" IS 'createTime';
COMMENT ON COLUMN "public"."hot"."hotcount" IS 'hotCount';
COMMENT ON TABLE "public"."hot" IS 'hot';

-- ----------------------------
-- Table structure for message
-- ----------------------------
DROP TABLE IF EXISTS "public"."message";
CREATE TABLE "public"."message" (
  "id" char(32) COLLATE "pg_catalog"."default" NOT NULL,
  "name" varchar(26) COLLATE "pg_catalog"."default" NOT NULL,
  "email" varchar(26) COLLATE "pg_catalog"."default" NOT NULL,
  "content" varchar(250) COLLATE "pg_catalog"."default" NOT NULL,
  "isRead" bool,
  "readTime" timestamp(0),
  "postTime" timestamp(0) DEFAULT now()
)
;
COMMENT ON COLUMN "public"."message"."id" IS 'id';
COMMENT ON COLUMN "public"."message"."name" IS 'name';
COMMENT ON COLUMN "public"."message"."email" IS 'email';
COMMENT ON COLUMN "public"."message"."content" IS 'content';
COMMENT ON COLUMN "public"."message"."isRead" IS 'isRead';
COMMENT ON COLUMN "public"."message"."readTime" IS 'readTime';
COMMENT ON COLUMN "public"."message"."postTime" IS 'postTime';
COMMENT ON TABLE "public"."message" IS 'message';

-- ----------------------------
-- Table structure for notify
-- ----------------------------
DROP TABLE IF EXISTS "public"."notify";
CREATE TABLE "public"."notify" (
  "id" char(32) COLLATE "pg_catalog"."default" NOT NULL,
  "content" varchar(250) COLLATE "pg_catalog"."default" NOT NULL,
  "createTime" timestamp(0) NOT NULL DEFAULT now(),
  "lastEditTime" timestamp(0) NOT NULL DEFAULT now(),
  "expireTime" timestamp(0),
  "isActive" bool
)
;
COMMENT ON COLUMN "public"."notify"."id" IS 'id';
COMMENT ON COLUMN "public"."notify"."content" IS 'content';
COMMENT ON COLUMN "public"."notify"."createTime" IS 'createTime';
COMMENT ON COLUMN "public"."notify"."lastEditTime" IS 'lastEditTime';
COMMENT ON COLUMN "public"."notify"."expireTime" IS 'expireTime';
COMMENT ON COLUMN "public"."notify"."isActive" IS 'isActive';
COMMENT ON TABLE "public"."notify" IS 'notify';

-- ----------------------------
-- Table structure for tag
-- ----------------------------
DROP TABLE IF EXISTS "public"."tag";
CREATE TABLE "public"."tag" (
  "id" char(32) COLLATE "pg_catalog"."default" NOT NULL,
  "name" varchar(50) COLLATE "pg_catalog"."default" NOT NULL,
  "clickNum" int4 DEFAULT 0,
  "createTime" timestamp(0) NOT NULL DEFAULT now()
)
;
COMMENT ON COLUMN "public"."tag"."id" IS 'id';
COMMENT ON COLUMN "public"."tag"."name" IS 'name';
COMMENT ON COLUMN "public"."tag"."clickNum" IS 'clickNum';
COMMENT ON COLUMN "public"."tag"."createTime" IS 'createTime';
COMMENT ON TABLE "public"."tag" IS 'tag';

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS "public"."user";
CREATE TABLE "public"."user" (
  "id" char(32) COLLATE "pg_catalog"."default" NOT NULL,
  "account" varchar(26) COLLATE "pg_catalog"."default" NOT NULL,
  "password" varchar(26) COLLATE "pg_catalog"."default" NOT NULL,
  "avatar" varchar(250) COLLATE "pg_catalog"."default",
  "email" varchar(250) COLLATE "pg_catalog"."default",
  "mobile" char(11) COLLATE "pg_catalog"."default",
  "createTime" timestamp(0) NOT NULL DEFAULT now(),
  "createIp" varchar(15) COLLATE "pg_catalog"."default",
  "lastLoginTime" timestamp(0),
  "userType" char(1) COLLATE "pg_catalog"."default",
  "setAdminTime" timestamp(0),
  "lastUpdateTime" timestamp(0) DEFAULT now()
)
;
COMMENT ON COLUMN "public"."user"."id" IS 'id';
COMMENT ON COLUMN "public"."user"."account" IS 'account';
COMMENT ON COLUMN "public"."user"."password" IS 'password';
COMMENT ON COLUMN "public"."user"."avatar" IS 'avatar';
COMMENT ON COLUMN "public"."user"."email" IS 'email';
COMMENT ON COLUMN "public"."user"."mobile" IS 'mobile';
COMMENT ON COLUMN "public"."user"."createTime" IS 'createTime';
COMMENT ON COLUMN "public"."user"."createIp" IS 'createIp';
COMMENT ON COLUMN "public"."user"."lastLoginTime" IS 'lastLoginTime';
COMMENT ON COLUMN "public"."user"."userType" IS 'userType';
COMMENT ON COLUMN "public"."user"."setAdminTime" IS 'setAdminTime';
COMMENT ON COLUMN "public"."user"."lastUpdateTime" IS 'lastUpdateTime';
COMMENT ON TABLE "public"."user" IS 'user';

-- ----------------------------
-- Primary Key structure for table article
-- ----------------------------
ALTER TABLE "public"."article" ADD CONSTRAINT "pk_article" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table category
-- ----------------------------
ALTER TABLE "public"."category" ADD CONSTRAINT "pk_category" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table comment
-- ----------------------------
ALTER TABLE "public"."comment" ADD CONSTRAINT "pk_comment" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table count
-- ----------------------------
ALTER TABLE "public"."count" ADD CONSTRAINT "pk_count" PRIMARY KEY ("id");

-- ----------------------------
-- Indexes structure for table hot
-- ----------------------------
CREATE UNIQUE INDEX "hot_id_idx" ON "public"."hot" USING btree (
  "id" COLLATE "pg_catalog"."default" "pg_catalog"."bpchar_ops" ASC NULLS LAST
);

-- ----------------------------
-- Primary Key structure for table hot
-- ----------------------------
ALTER TABLE "public"."hot" ADD CONSTRAINT "pk_hot" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table message
-- ----------------------------
ALTER TABLE "public"."message" ADD CONSTRAINT "pk_message" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table notify
-- ----------------------------
ALTER TABLE "public"."notify" ADD CONSTRAINT "pk_notify" PRIMARY KEY ("id");

-- ----------------------------
-- Indexes structure for table tag
-- ----------------------------
CREATE UNIQUE INDEX "tag_id_idx" ON "public"."tag" USING btree (
  "id" COLLATE "pg_catalog"."default" "pg_catalog"."bpchar_ops" ASC NULLS LAST
);

-- ----------------------------
-- Primary Key structure for table tag
-- ----------------------------
ALTER TABLE "public"."tag" ADD CONSTRAINT "pk_tag" PRIMARY KEY ("id");

-- ----------------------------
-- Indexes structure for table user
-- ----------------------------
CREATE UNIQUE INDEX "di" ON "public"."user" USING btree (
  "id" COLLATE "pg_catalog"."default" "pg_catalog"."bpchar_ops" ASC NULLS LAST
);

-- ----------------------------
-- Primary Key structure for table user
-- ----------------------------
ALTER TABLE "public"."user" ADD CONSTRAINT "pk_user" PRIMARY KEY ("id");

-- ----------------------------
-- Foreign Keys structure for table article
-- ----------------------------
ALTER TABLE "public"."article" ADD CONSTRAINT "fk_article_cate_category" FOREIGN KEY ("category") REFERENCES "public"."category" ("id") ON DELETE RESTRICT ON UPDATE RESTRICT;
ALTER TABLE "public"."article" ADD CONSTRAINT "fk_article_tag_tag" FOREIGN KEY ("tag") REFERENCES "public"."tag" ("id") ON DELETE RESTRICT ON UPDATE RESTRICT;
ALTER TABLE "public"."article" ADD CONSTRAINT "fk_article_user_user" FOREIGN KEY ("creator") REFERENCES "public"."user" ("id") ON DELETE RESTRICT ON UPDATE RESTRICT;

-- ----------------------------
-- Foreign Keys structure for table comment
-- ----------------------------
ALTER TABLE "public"."comment" ADD CONSTRAINT "comment_parentComment_fkey" FOREIGN KEY ("parentComment") REFERENCES "public"."comment" ("id") ON DELETE RESTRICT ON UPDATE RESTRICT;
ALTER TABLE "public"."comment" ADD CONSTRAINT "fk_comment_article_article" FOREIGN KEY ("article") REFERENCES "public"."article" ("id") ON DELETE RESTRICT ON UPDATE RESTRICT;
