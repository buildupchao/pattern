package com.pattern.tutor.netty.netty.serial;
///*
//package com.jangz.nettypro.netty.serial;
//
//import io.netty.bootstrap.ServerBootstrap;
//import io.netty.channel.ChannelFuture;
//import io.netty.channel.ChannelInitializer;
//import io.netty.channel.ChannelOption;
//import io.netty.channel.EventLoopGroup;
//import io.netty.channel.nio.NioEventLoopGroup;
//import io.netty.channel.socket.SocketChannel;
//import io.netty.channel.socket.nio.NioServerSocketChannel;
//import io.netty.handler.codec.serialization.ClassResolvers;
//import io.netty.handler.codec.serialization.ObjectDecoder;
//import io.netty.handler.codec.serialization.ObjectEncoder;
//import io.netty.handler.logging.LogLevel;
//import io.netty.handler.logging.LoggingHandler;
//
//public class SubReqServer {
//
//	public void bind(int port) throws Exception {
//		EventLoopGroup boosGroup = new NioEventLoopGroup();
//		EventLoopGroup workerGroup = new NioEventLoopGroup();
//
//		try {
//			ServerBootstrap b = new ServerBootstrap();
//			b.group(boosGroup, workerGroup)
//				.channel(NioServerSocketChannel.class)
//				.option(ChannelOption.SO_BACKLOG, 1024)
//				.handler(new LoggingHandler(LogLevel.INFO))
//				.childHandler(new ChannelInitializer<SocketChannel>() {
//
//					@Override
//					protected void initChannel(SocketChannel ch) throws Exception {
//						ch.pipeline().addLast(new ObjectDecoder(1024 * 1024,
//								ClassResolvers.weakCachingConcurrentResolver(this.getClass().getClassLoader())));
//						ch.pipeline().addLast(new ObjectEncoder());
//						ch.pipeline().addLast(new SubReqServerHandler());
//					}
//				});
//
//			ChannelFuture f = b.bind(port).sync();
//			f.channel().closeFuture().sync();
//		} finally {
//			boosGroup.shutdownGracefully();
//			workerGroup.shutdownGracefully();
//		}
//	}
//
//	public static void main(String[] args) throws Exception {
//		int port = 9000;
//
//		if (args != null && args.length > 0) {
//			try {
//				port = Integer.parseInt(args[0]);
//			} catch (NumberFormatException ex) {
//
//			}
//		}
//		new SubReqServer().bind(port);
//	}
//}
//*/
