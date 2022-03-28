
import 'dart:async';

import 'package:flutter/services.dart';

class StackAnalytix {
  static const MethodChannel _channel = MethodChannel('StackAnalytix');
  static Future<String?> get stackAnalytix async {
    final String? load = await _channel.invokeMethod('StackAnalytix');
    return load;
  }
}
