//
//  KotlinMultiplatformPlaygroundTests.swift
//  KotlinMultiplatformPlaygroundTests
//
//  Created by Tarek Belkahia on 15/02/2018.
//  Copyright © 2018 Tarek Belkahia. All rights reserved.
//

import XCTest
import KotlinMultiplatformPlaygroundLib
@testable import KotlinMultiplatformPlayground

class KotlinMultiplatformPlaygroundTests: XCTestCase {
    
    func testCommon() {
        XCTAssertEqual("common", KMPLCommon().common())
    }

    func testPlatform() {
        XCTAssertEqual("platform-native", KMPLCommon().platform())
    }
}
