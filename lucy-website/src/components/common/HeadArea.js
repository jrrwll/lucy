import {FormattedMessage} from "react-intl";
import React from "react";
import {Layout, Menu} from 'antd';

const {Header} = Layout;

export default function HeadArea() {
    return (
        <Header>
            <div className="logo"/>
            <Menu theme="dark" mode="horizontal" defaultSelectedKeys={['home']}>
                <Menu.Item key="home"><FormattedMessage id="common.head.home"/></Menu.Item>
                <Menu.Item key="shorten"><FormattedMessage id="common.head.shorten"/></Menu.Item>
                <Menu.Item key="network"><FormattedMessage id="common.head.network"/></Menu.Item>

                <Menu.Item key="crypt"><FormattedMessage id="common.head.crypt"/></Menu.Item>
                <Menu.Item key="word"><FormattedMessage id="common.head.word"/></Menu.Item>
            </Menu>
        </Header>
    );
}
