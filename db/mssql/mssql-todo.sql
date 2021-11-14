USE [master]
GO

IF DB_ID('todo') IS NOT NULL
  set noexec on               -- prevent creation when already exists

/****** Object:  Database [todo]   ******/
CREATE DATABASE [todo];
GO

USE [todo]
GO