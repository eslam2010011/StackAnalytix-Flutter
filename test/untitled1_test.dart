import 'package:flutter/services.dart';
import 'package:flutter_test/flutter_test.dart';
import 'package:untitled1/stackanalytix.dart';

void main() {
  const MethodChannel channel = MethodChannel('StackAnalytix');

  TestWidgetsFlutterBinding.ensureInitialized();

  setUp(() {
    channel.setMockMethodCallHandler((MethodCall methodCall) async {
      return '42';
    });
  });

  tearDown(() {
    channel.setMockMethodCallHandler(null);
  });

  test('StackAnalytix', () async {
    expect(await StackAnalytix.stackAnalytix, '42');
  });
}
