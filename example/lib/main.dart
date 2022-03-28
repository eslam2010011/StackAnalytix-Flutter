import 'package:flutter/material.dart';
import 'dart:async';

import 'package:flutter/services.dart';
import 'package:untitled1/stackanalytix.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatefulWidget {
  const MyApp({Key? key}) : super(key: key);

  @override
  State<MyApp> createState() => _MyAppState();
}

class _MyAppState extends State<MyApp> {
  String _stackAnalytix = 'Unknown';

  @override
  void initState() {
    super.initState();
    initPlatformState();
  }

   Future<void> initPlatformState() async {
    String stackAnalytix;
    try {
      stackAnalytix =
          await StackAnalytix.stackAnalytix ?? 'Unknown lib';
    } on PlatformException {
      stackAnalytix = 'Failed load lib.';
    }

    if (!mounted) return;

    setState(() {
      _stackAnalytix = stackAnalytix;
    });
  }

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(
          title: const Text('Plugin example app'),
        ),
        body: Center(
          child: Text('Running on: $_stackAnalytix\n'),
        ),
      ),
    );
  }
}
