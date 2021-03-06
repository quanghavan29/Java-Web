USE [master]
GO
/****** Object:  Database [Project_Block5]    Script Date: 4/13/2021 7:39:25 PM ******/
CREATE DATABASE [Project_Block5]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'Project_Block5', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.MSSQLSERVER\MSSQL\DATA\Project_Block5.mdf' , SIZE = 3264KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'Project_Block5_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.MSSQLSERVER\MSSQL\DATA\Project_Block5_log.ldf' , SIZE = 832KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [Project_Block5] SET COMPATIBILITY_LEVEL = 120
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [Project_Block5].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [Project_Block5] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [Project_Block5] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [Project_Block5] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [Project_Block5] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [Project_Block5] SET ARITHABORT OFF 
GO
ALTER DATABASE [Project_Block5] SET AUTO_CLOSE ON 
GO
ALTER DATABASE [Project_Block5] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [Project_Block5] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [Project_Block5] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [Project_Block5] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [Project_Block5] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [Project_Block5] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [Project_Block5] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [Project_Block5] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [Project_Block5] SET  ENABLE_BROKER 
GO
ALTER DATABASE [Project_Block5] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [Project_Block5] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [Project_Block5] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [Project_Block5] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [Project_Block5] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [Project_Block5] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [Project_Block5] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [Project_Block5] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [Project_Block5] SET  MULTI_USER 
GO
ALTER DATABASE [Project_Block5] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [Project_Block5] SET DB_CHAINING OFF 
GO
ALTER DATABASE [Project_Block5] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [Project_Block5] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
ALTER DATABASE [Project_Block5] SET DELAYED_DURABILITY = DISABLED 
GO
USE [Project_Block5]
GO
/****** Object:  Table [dbo].[Cart]    Script Date: 4/13/2021 7:39:25 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Cart](
	[cartId] [int] IDENTITY(1,1) NOT NULL,
	[userId] [int] NOT NULL,
	[productId] [int] NOT NULL,
	[quantity] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[cartId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Categories]    Script Date: 4/13/2021 7:39:25 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Categories](
	[categoriesId] [int] IDENTITY(1,1) NOT NULL,
	[categoriesName] [varchar](50) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[categoriesId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Orders]    Script Date: 4/13/2021 7:39:25 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Orders](
	[orderId] [int] IDENTITY(1,1) NOT NULL,
	[userId] [int] NOT NULL,
	[productId] [int] NOT NULL,
	[quantity] [int] NOT NULL,
	[orderDate] [date] NOT NULL,
	[status] [varchar](50) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[orderId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Product]    Script Date: 4/13/2021 7:39:25 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Product](
	[productId] [int] IDENTITY(1,1) NOT NULL,
	[categoriesId] [int] NOT NULL,
	[productName] [varchar](50) NOT NULL,
	[price] [float] NOT NULL,
	[quantity] [int] NOT NULL,
	[productDescription] [text] NOT NULL,
	[image] [text] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[productId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Product_Details]    Script Date: 4/13/2021 7:39:25 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Product_Details](
	[productId] [int] NOT NULL,
	[colorId] [int] NOT NULL,
	[sizeId] [int] NOT NULL,
	[quantity] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[productId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Sale]    Script Date: 4/13/2021 7:39:25 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Sale](
	[productId] [int] NOT NULL,
	[saleId] [varchar](50) NOT NULL,
	[salePrice] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[saleId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Size]    Script Date: 4/13/2021 7:39:25 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Size](
	[sizeId] [int] NOT NULL,
	[sizeName] [varchar](50) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[sizeId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[User]    Script Date: 4/13/2021 7:39:25 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[User](
	[userId] [int] IDENTITY(1,1) NOT NULL,
	[username] [varchar](100) NOT NULL,
	[password] [varchar](100) NOT NULL,
	[fullName] [varchar](150) NULL,
	[phone] [varchar](100) NOT NULL,
	[address] [varchar](150) NOT NULL,
	[gender] [bit] NULL,
	[role] [varchar](100) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[userId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[Cart] ON 

INSERT [dbo].[Cart] ([cartId], [userId], [productId], [quantity]) VALUES (8, 4, 4, 2)
INSERT [dbo].[Cart] ([cartId], [userId], [productId], [quantity]) VALUES (50, 36, 5, 1)
INSERT [dbo].[Cart] ([cartId], [userId], [productId], [quantity]) VALUES (51, 36, 4, 1)
INSERT [dbo].[Cart] ([cartId], [userId], [productId], [quantity]) VALUES (56, 37, 29, 1)
INSERT [dbo].[Cart] ([cartId], [userId], [productId], [quantity]) VALUES (58, 39, 5, 1)
SET IDENTITY_INSERT [dbo].[Cart] OFF
GO
SET IDENTITY_INSERT [dbo].[Categories] ON 

INSERT [dbo].[Categories] ([categoriesId], [categoriesName]) VALUES (1, N'Vans old skool')
INSERT [dbo].[Categories] ([categoriesId], [categoriesName]) VALUES (2, N'Vans slip on')
INSERT [dbo].[Categories] ([categoriesId], [categoriesName]) VALUES (3, N'Vans authentic')
SET IDENTITY_INSERT [dbo].[Categories] OFF
GO
SET IDENTITY_INSERT [dbo].[Orders] ON 

INSERT [dbo].[Orders] ([orderId], [userId], [productId], [quantity], [orderDate], [status]) VALUES (28, 3, 4, 2, CAST(N'2020-12-15' AS Date), N'success')
INSERT [dbo].[Orders] ([orderId], [userId], [productId], [quantity], [orderDate], [status]) VALUES (29, 3, 3, 1, CAST(N'2020-12-15' AS Date), N'success')
INSERT [dbo].[Orders] ([orderId], [userId], [productId], [quantity], [orderDate], [status]) VALUES (30, 3, 7, 3, CAST(N'2020-12-15' AS Date), N'success')
INSERT [dbo].[Orders] ([orderId], [userId], [productId], [quantity], [orderDate], [status]) VALUES (31, 5, 4, 2, CAST(N'2020-12-15' AS Date), N'success')
INSERT [dbo].[Orders] ([orderId], [userId], [productId], [quantity], [orderDate], [status]) VALUES (32, 6, 28, 3, CAST(N'2020-12-15' AS Date), N'success')
INSERT [dbo].[Orders] ([orderId], [userId], [productId], [quantity], [orderDate], [status]) VALUES (33, 6, 3, 2, CAST(N'2020-12-15' AS Date), N'success')
INSERT [dbo].[Orders] ([orderId], [userId], [productId], [quantity], [orderDate], [status]) VALUES (34, 11, 4, 2, CAST(N'2020-12-15' AS Date), N'success')
INSERT [dbo].[Orders] ([orderId], [userId], [productId], [quantity], [orderDate], [status]) VALUES (35, 12, 4, 3, CAST(N'2020-12-16' AS Date), N'success')
INSERT [dbo].[Orders] ([orderId], [userId], [productId], [quantity], [orderDate], [status]) VALUES (36, 12, 23, 2, CAST(N'2020-12-16' AS Date), N'success')
INSERT [dbo].[Orders] ([orderId], [userId], [productId], [quantity], [orderDate], [status]) VALUES (37, 13, 3, 2, CAST(N'2020-12-16' AS Date), N'success')
INSERT [dbo].[Orders] ([orderId], [userId], [productId], [quantity], [orderDate], [status]) VALUES (38, 13, 5, 1, CAST(N'2020-12-16' AS Date), N'success')
INSERT [dbo].[Orders] ([orderId], [userId], [productId], [quantity], [orderDate], [status]) VALUES (39, 14, 23, 3, CAST(N'2020-12-18' AS Date), N'success')
INSERT [dbo].[Orders] ([orderId], [userId], [productId], [quantity], [orderDate], [status]) VALUES (40, 14, 3, 1, CAST(N'2020-12-18' AS Date), N'success')
INSERT [dbo].[Orders] ([orderId], [userId], [productId], [quantity], [orderDate], [status]) VALUES (48, 2, 9, 2, CAST(N'2020-12-19' AS Date), N'success')
INSERT [dbo].[Orders] ([orderId], [userId], [productId], [quantity], [orderDate], [status]) VALUES (51, 30, 4, 2, CAST(N'2020-12-20' AS Date), N'success')
INSERT [dbo].[Orders] ([orderId], [userId], [productId], [quantity], [orderDate], [status]) VALUES (52, 30, 5, 1, CAST(N'2020-12-20' AS Date), N'success')
INSERT [dbo].[Orders] ([orderId], [userId], [productId], [quantity], [orderDate], [status]) VALUES (53, 30, 3, 3, CAST(N'2020-12-20' AS Date), N'success')
INSERT [dbo].[Orders] ([orderId], [userId], [productId], [quantity], [orderDate], [status]) VALUES (54, 30, 7, 2, CAST(N'2020-12-20' AS Date), N'success')
INSERT [dbo].[Orders] ([orderId], [userId], [productId], [quantity], [orderDate], [status]) VALUES (55, 33, 5, 2, CAST(N'2020-12-20' AS Date), N'success')
INSERT [dbo].[Orders] ([orderId], [userId], [productId], [quantity], [orderDate], [status]) VALUES (56, 33, 3, 1, CAST(N'2020-12-20' AS Date), N'success')
INSERT [dbo].[Orders] ([orderId], [userId], [productId], [quantity], [orderDate], [status]) VALUES (57, 34, 28, 1, CAST(N'2020-12-20' AS Date), N'success')
INSERT [dbo].[Orders] ([orderId], [userId], [productId], [quantity], [orderDate], [status]) VALUES (58, 36, 5, 2, CAST(N'2020-12-21' AS Date), N'success')
INSERT [dbo].[Orders] ([orderId], [userId], [productId], [quantity], [orderDate], [status]) VALUES (60, 37, 12, 3, CAST(N'2020-12-21' AS Date), N'success')
INSERT [dbo].[Orders] ([orderId], [userId], [productId], [quantity], [orderDate], [status]) VALUES (61, 38, 7, 2, CAST(N'2020-12-22' AS Date), N'success')
INSERT [dbo].[Orders] ([orderId], [userId], [productId], [quantity], [orderDate], [status]) VALUES (62, 40, 3, 1, CAST(N'2020-12-22' AS Date), N'success')
INSERT [dbo].[Orders] ([orderId], [userId], [productId], [quantity], [orderDate], [status]) VALUES (63, 40, 4, 1, CAST(N'2020-12-22' AS Date), N'success')
INSERT [dbo].[Orders] ([orderId], [userId], [productId], [quantity], [orderDate], [status]) VALUES (66, 3, 4, 1, CAST(N'2020-12-24' AS Date), N'waiting_line')
INSERT [dbo].[Orders] ([orderId], [userId], [productId], [quantity], [orderDate], [status]) VALUES (67, 42, 23, 2, CAST(N'2020-12-29' AS Date), N'success')
INSERT [dbo].[Orders] ([orderId], [userId], [productId], [quantity], [orderDate], [status]) VALUES (68, 42, 3, 3, CAST(N'2020-12-29' AS Date), N'success')
INSERT [dbo].[Orders] ([orderId], [userId], [productId], [quantity], [orderDate], [status]) VALUES (69, 43, 23, 2, CAST(N'2020-12-29' AS Date), N'success')
INSERT [dbo].[Orders] ([orderId], [userId], [productId], [quantity], [orderDate], [status]) VALUES (70, 43, 3, 1, CAST(N'2020-12-29' AS Date), N'success')
INSERT [dbo].[Orders] ([orderId], [userId], [productId], [quantity], [orderDate], [status]) VALUES (71, 44, 23, 2, CAST(N'2020-12-29' AS Date), N'waiting_line')
INSERT [dbo].[Orders] ([orderId], [userId], [productId], [quantity], [orderDate], [status]) VALUES (72, 44, 3, 1, CAST(N'2020-12-29' AS Date), N'waiting_line')
INSERT [dbo].[Orders] ([orderId], [userId], [productId], [quantity], [orderDate], [status]) VALUES (73, 45, 23, 3, CAST(N'2020-12-29' AS Date), N'waiting_line')
INSERT [dbo].[Orders] ([orderId], [userId], [productId], [quantity], [orderDate], [status]) VALUES (74, 45, 41, 1, CAST(N'2020-12-29' AS Date), N'waiting_line')
INSERT [dbo].[Orders] ([orderId], [userId], [productId], [quantity], [orderDate], [status]) VALUES (75, 3, 3, 2, CAST(N'2021-01-16' AS Date), N'waiting_line')
INSERT [dbo].[Orders] ([orderId], [userId], [productId], [quantity], [orderDate], [status]) VALUES (76, 3, 4, 1, CAST(N'2021-01-16' AS Date), N'waiting_line')
INSERT [dbo].[Orders] ([orderId], [userId], [productId], [quantity], [orderDate], [status]) VALUES (77, 3, 5, 1, CAST(N'2021-01-16' AS Date), N'waiting_line')
SET IDENTITY_INSERT [dbo].[Orders] OFF
GO
SET IDENTITY_INSERT [dbo].[Product] ON 

INSERT [dbo].[Product] ([productId], [categoriesId], [productName], [price], [quantity], [productDescription], [image]) VALUES (3, 1, N'Vans old skool', 50, 155, N'Old Skool Platform Sneakers - Black', N'vans-old-skool1.jpg')
INSERT [dbo].[Product] ([productId], [categoriesId], [productName], [price], [quantity], [productDescription], [image]) VALUES (4, 1, N'Vans old skool', 55, 10, N'Old Skool Black White Canvas Sneakers', N'vans-old-skool2.jpg')
INSERT [dbo].[Product] ([productId], [categoriesId], [productName], [price], [quantity], [productDescription], [image]) VALUES (5, 1, N'Vans old skool', 45, 10, N'Classic Slip On Checkboard Sneakers - White', N'vans-old-skool3.jpg')
INSERT [dbo].[Product] ([productId], [categoriesId], [productName], [price], [quantity], [productDescription], [image]) VALUES (7, 1, N'Vans old skool', 40, 20, N'Old Skool Platform Sneakers - Black', N'vans-old-skool4.jpg')
INSERT [dbo].[Product] ([productId], [categoriesId], [productName], [price], [quantity], [productDescription], [image]) VALUES (9, 1, N'Vans old skool', 49, 15, N'Old Skool Black White Canvas Sneakers', N'vans-old-skool5.jpg')
INSERT [dbo].[Product] ([productId], [categoriesId], [productName], [price], [quantity], [productDescription], [image]) VALUES (12, 1, N'Vans old skool', 39, 12, N'Old Skool Black White Canvas Sneakers', N'vans-old-skool6.jpg')
INSERT [dbo].[Product] ([productId], [categoriesId], [productName], [price], [quantity], [productDescription], [image]) VALUES (13, 1, N'Vans old skool', 55, 7, N'Old Skool Black White Canvas Sneakers', N'vans-old-skool7.jpg')
INSERT [dbo].[Product] ([productId], [categoriesId], [productName], [price], [quantity], [productDescription], [image]) VALUES (17, 1, N'Vans old skool', 59, 10, N'Classic Slip On Checkboard Sneakers - White', N'vans-old-skool8.jpg')
INSERT [dbo].[Product] ([productId], [categoriesId], [productName], [price], [quantity], [productDescription], [image]) VALUES (23, 2, N'Vans authentic', 44, 12, N'Old Skool Black White Canvas Sneakers', N'vans-authentic1.jpg')
INSERT [dbo].[Product] ([productId], [categoriesId], [productName], [price], [quantity], [productDescription], [image]) VALUES (24, 2, N'Vans authentic', 49, 5, N'Old Skool Black White Canvas Sneakers', N'vans-authentic2.jpg')
INSERT [dbo].[Product] ([productId], [categoriesId], [productName], [price], [quantity], [productDescription], [image]) VALUES (26, 2, N'Vans authentic', 55, 55, N'Old Skool Black White Canvas Sneakers', N'vans-authentic3.jpg')
INSERT [dbo].[Product] ([productId], [categoriesId], [productName], [price], [quantity], [productDescription], [image]) VALUES (27, 2, N'Vans authentic', 49, 34, N'Old Skool Platform Sneakers - Black', N'vans-authentic4.jpg')
INSERT [dbo].[Product] ([productId], [categoriesId], [productName], [price], [quantity], [productDescription], [image]) VALUES (28, 2, N'Vans authentic', 45, 12, N'Classic Slip On Checkboard Sneakers - White', N'vans-authentic5.jpg')
INSERT [dbo].[Product] ([productId], [categoriesId], [productName], [price], [quantity], [productDescription], [image]) VALUES (29, 2, N'Vans authentic', 65, 12, N'Classic Slip On Checkboard Sneakers - White', N'vans-authentic6.jpg')
INSERT [dbo].[Product] ([productId], [categoriesId], [productName], [price], [quantity], [productDescription], [image]) VALUES (30, 2, N'Vans slip on', 49, 13, N'This is new product - vans slip on', N'vans-old-skool1.jpg')
INSERT [dbo].[Product] ([productId], [categoriesId], [productName], [price], [quantity], [productDescription], [image]) VALUES (39, 1, N'Vans authentic', 59, 150, N'	Old Skool Black White Canvas Sneakers', N'vans-authentic5.jpg')
INSERT [dbo].[Product] ([productId], [categoriesId], [productName], [price], [quantity], [productDescription], [image]) VALUES (40, 1, N'Vans old skool', 45, 90, N'Old Skool Black White Canvas Sneakers', N'vans-old-skool5.jpg')
INSERT [dbo].[Product] ([productId], [categoriesId], [productName], [price], [quantity], [productDescription], [image]) VALUES (41, 1, N'Vans old skool', 59, 76, N'Old Skool Black White Canvas Sneakers', N'vans-old-skool8.jpg')
INSERT [dbo].[Product] ([productId], [categoriesId], [productName], [price], [quantity], [productDescription], [image]) VALUES (43, 1, N'Vans old skool', 50, 45, N'Classic Slip On Checkboard Sneakers - White', N'vans-old-skool5.jpg')
SET IDENTITY_INSERT [dbo].[Product] OFF
GO
SET IDENTITY_INSERT [dbo].[User] ON 

INSERT [dbo].[User] ([userId], [username], [password], [fullName], [phone], [address], [gender], [role]) VALUES (1, N'mra', N'aloha', N'Trinh The Hoan', N'0968904962', N'FPT University - Thach Hoa - Thach That - Ha Noi', 1, N'ROLE_admin')
INSERT [dbo].[User] ([userId], [username], [password], [fullName], [phone], [address], [gender], [role]) VALUES (2, N'mrb', N'rytug', N'Mr.B', N'0948625454', N'America', 1, N'ROLE_member')
INSERT [dbo].[User] ([userId], [username], [password], [fullName], [phone], [address], [gender], [role]) VALUES (3, N'coosi29', N'123', N'Ha Van Quang', N'0968904962', N'Lai Cach - Xua Giang - Soc Son - Ha Noi', 1, N'ROLE_user')
INSERT [dbo].[User] ([userId], [username], [password], [fullName], [phone], [address], [gender], [role]) VALUES (4, N'xxxxvideos', N'456', N'Mr. Koturerge', N'0973645323', N'Xa Dan - Thuong Tin - Thanh Hoa', 1, N'ROLE_member')
INSERT [dbo].[User] ([userId], [username], [password], [fullName], [phone], [address], [gender], [role]) VALUES (5, N'truongnt5', N'123', N'Tran Dinh Dai', N'0923946234', N'Da Lat', 1, N'ROLE_user')
INSERT [dbo].[User] ([userId], [username], [password], [fullName], [phone], [address], [gender], [role]) VALUES (6, N'hahaha', N'abc', N'Ha Thi Hoa', N'0963223453', N'Da Nang', 1, N'ROLE_user')
INSERT [dbo].[User] ([userId], [username], [password], [fullName], [phone], [address], [gender], [role]) VALUES (9, N'admin', N'admin', N'Mr.Admin', N'0968904962', N'Ho Tay - Ha Noi', 0, N'ROLE_admin')
INSERT [dbo].[User] ([userId], [username], [password], [fullName], [phone], [address], [gender], [role]) VALUES (10, N'abct29', N'345', N'Nguyen Thi Tra My', N'0968904962', N'Lai Cach - Xuan Giang - Soc Son - Ha Noi', 0, N'ROLE_user')
INSERT [dbo].[User] ([userId], [username], [password], [fullName], [phone], [address], [gender], [role]) VALUES (11, N'kaka', N'345', N'Nguyen Dinh Khue', N'0976384733', N'TP HCM', 1, N'ROLE_member')
INSERT [dbo].[User] ([userId], [username], [password], [fullName], [phone], [address], [gender], [role]) VALUES (12, N'cuongpront5', N'cuonglaso1', N'', N'0495759458', N'Gia Loc - Hai Duong', 1, N'ROLE_user')
INSERT [dbo].[User] ([userId], [username], [password], [fullName], [phone], [address], [gender], [role]) VALUES (13, N'oklala', N'oklala', N'Mr. Ok La La', N'0947463648', N'Califorlia - America', 1, N'ROLE_user')
INSERT [dbo].[User] ([userId], [username], [password], [fullName], [phone], [address], [gender], [role]) VALUES (14, N'futura', N'futura', N'', N'0123123123', N'Futura - Tokyo - Japan', 1, N'ROLE_user')
INSERT [dbo].[User] ([userId], [username], [password], [fullName], [phone], [address], [gender], [role]) VALUES (17, N'ads', N'asd', N'asd', N'asdas', N'asd', 1, N'ROLE_admin')
INSERT [dbo].[User] ([userId], [username], [password], [fullName], [phone], [address], [gender], [role]) VALUES (18, N'hiroiky', N'123456', N'Ha Thi Anh', N'0232343434', N'Thanh Xuan - Nguyen Trai - Ha Noi', 0, N'ROLE_user')
INSERT [dbo].[User] ([userId], [username], [password], [fullName], [phone], [address], [gender], [role]) VALUES (19, N'dertygu', N'abx', N'Ngo Gia Binh', N'0974635243', N'Tran Duy Hung - Cau Giay - Ha Noi', 1, N'ROLE_member')
INSERT [dbo].[User] ([userId], [username], [password], [fullName], [phone], [address], [gender], [role]) VALUES (27, N'delete', N'456', N'Ha Van Quang', N'0989898989', N'acbxyz', 1, N'ROLE_admin')
INSERT [dbo].[User] ([userId], [username], [password], [fullName], [phone], [address], [gender], [role]) VALUES (30, N'buyguro', N'eww', N'', N'0989898989', N'Hai Phong', 1, N'ROLE_user')
INSERT [dbo].[User] ([userId], [username], [password], [fullName], [phone], [address], [gender], [role]) VALUES (32, N'kurokoi', N'345', N'Kuroiloiker', N'0989898989', N'Thanh Xuan - Ha Noi', 0, N'ROLE_member')
INSERT [dbo].[User] ([userId], [username], [password], [fullName], [phone], [address], [gender], [role]) VALUES (33, N'hukirpo', N'hukirpo', N'', N'0943638434', N'Dai Dong Thanh - Gia Lam - Binh Phuoc', 1, N'ROLE_user')
INSERT [dbo].[User] ([userId], [username], [password], [fullName], [phone], [address], [gender], [role]) VALUES (34, N'derkire', N'noret', N'', N'0386384634', N'Binh Thanh - Binh Phuc - Ha Nam', 1, N'ROLE_user')
INSERT [dbo].[User] ([userId], [username], [password], [fullName], [phone], [address], [gender], [role]) VALUES (35, N'aecle', N'123', N'', N'0123123123', N'FPT University - Hoa Lac - Thach That - Ha Noi', 1, N'ROLE_user')
INSERT [dbo].[User] ([userId], [username], [password], [fullName], [phone], [address], [gender], [role]) VALUES (36, N'heroiker', N'soso', N'', N'0938473634', N'Hoa Binh - Son La', 1, N'ROLE_user')
INSERT [dbo].[User] ([userId], [username], [password], [fullName], [phone], [address], [gender], [role]) VALUES (37, N'borierki', N'bober', N'', N'0346283743', N'New York City - America', 1, N'ROLE_user')
INSERT [dbo].[User] ([userId], [username], [password], [fullName], [phone], [address], [gender], [role]) VALUES (38, N'nubutoi', N'rere', N'', N'0923482343', N'Nam Dan - Thanh Hoa - Nghe An', 1, N'ROLE_user')
INSERT [dbo].[User] ([userId], [username], [password], [fullName], [phone], [address], [gender], [role]) VALUES (39, N'mkiku', N'123', N'', N'0989898989', N'FPT University - Hoa Lac - Thach That - Ha Noi', 1, N'ROLE_user')
INSERT [dbo].[User] ([userId], [username], [password], [fullName], [phone], [address], [gender], [role]) VALUES (40, N'alolotaka', N'456', N'Ha Van Quang', N'0362537463', N'Cung Tien - Han Thai - Binh Dinh', 1, N'ROLE_member')
INSERT [dbo].[User] ([userId], [username], [password], [fullName], [phone], [address], [gender], [role]) VALUES (42, N'aloka', N'321', N'', N'0999999999', N'FPT University - Hoa Lac - Thach That - Ha Noi', 1, N'ROLE_user')
INSERT [dbo].[User] ([userId], [username], [password], [fullName], [phone], [address], [gender], [role]) VALUES (43, N'alokaka', N'321', N'', N'0989898989', N'FPT University - Hoa Lac - Thach That - Ha Noi', 1, N'ROLE_user')
INSERT [dbo].[User] ([userId], [username], [password], [fullName], [phone], [address], [gender], [role]) VALUES (44, N'alokakaha', N'321', N'', N'0989898989', N'FPT University - Hoa Lac - Thach That - Ha Noi', 1, N'ROLE_user')
INSERT [dbo].[User] ([userId], [username], [password], [fullName], [phone], [address], [gender], [role]) VALUES (45, N'ahihihaha', N'321', N'', N'0989898989', N'FPT University - Hoa Lac - Thach That - Ha Noi', 1, N'ROLE_user')
SET IDENTITY_INSERT [dbo].[User] OFF
GO
ALTER TABLE [dbo].[Cart]  WITH CHECK ADD FOREIGN KEY([productId])
REFERENCES [dbo].[Product] ([productId])
GO
ALTER TABLE [dbo].[Cart]  WITH CHECK ADD FOREIGN KEY([userId])
REFERENCES [dbo].[User] ([userId])
GO
ALTER TABLE [dbo].[Orders]  WITH CHECK ADD FOREIGN KEY([productId])
REFERENCES [dbo].[Product] ([productId])
GO
ALTER TABLE [dbo].[Orders]  WITH CHECK ADD FOREIGN KEY([userId])
REFERENCES [dbo].[User] ([userId])
GO
ALTER TABLE [dbo].[Product]  WITH CHECK ADD FOREIGN KEY([categoriesId])
REFERENCES [dbo].[Categories] ([categoriesId])
GO
ALTER TABLE [dbo].[Product_Details]  WITH CHECK ADD FOREIGN KEY([productId])
REFERENCES [dbo].[Product] ([productId])
GO
ALTER TABLE [dbo].[Product_Details]  WITH CHECK ADD FOREIGN KEY([sizeId])
REFERENCES [dbo].[Size] ([sizeId])
GO
ALTER TABLE [dbo].[Sale]  WITH CHECK ADD FOREIGN KEY([productId])
REFERENCES [dbo].[Product] ([productId])
GO
USE [master]
GO
ALTER DATABASE [Project_Block5] SET  READ_WRITE 
GO
